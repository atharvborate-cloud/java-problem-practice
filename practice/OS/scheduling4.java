package practice.OS;

import java.util.*;

public class scheduling4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        System.out.print("Enter Time Quantum: ");
        int tq = sc.nextInt();

        // [pid, arrival time, burst time, remaining time]
        int[][] processes = new int[n][4];

        for (int i = 0; i < n; i++) {
            int pid = i + 1;

            System.out.print("Enter Arrival Time for P" + pid + ": ");
            int at = sc.nextInt();

            System.out.print("Enter Burst Time for P" + pid + ": ");
            int bt = sc.nextInt();

            processes[i][0] = pid;
            processes[i][1] = at;
            processes[i][2] = bt;
            processes[i][3] = bt; // remaining time
        }

        int time = 0, completed = 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        int[] wt = new int[n];
        int[] tat = new int[n];

        List<String> timeline = new ArrayList<>();

        // ---- Scheduling ----
        while (completed < n) {

            // Add newly arrived processes
            for (int i = 0; i < n; i++) {
                if (processes[i][1] <= time && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }

            // CPU Idle
            if (queue.isEmpty()) {
                timeline.add("Idle");
                time++;
                continue;
            }

            int i = queue.poll();

            int pid = processes[i][0];
            int at = processes[i][1];
            int bt = processes[i][2];

            int exec = Math.min(tq, processes[i][3]);

            // Execute process
            for (int t = 0; t < exec; t++) {
                timeline.add("P" + pid);
                time++;

                // Check new arrivals during execution
                for (int j = 0; j < n; j++) {
                    if (processes[j][1] <= time && !visited[j]) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }

            processes[i][3] -= exec;

            // If not finished → add back to queue
            if (processes[i][3] > 0) {
                queue.add(i);
            } else {
                completed++;
                tat[pid - 1] = time - at;
                wt[pid - 1] = tat[pid - 1] - bt;
            }
        }

        // ---- Convert timeline → Gantt blocks ----
        List<String[]> gantt = new ArrayList<>();
        int start = 0;

        for (int i = 1; i < timeline.size(); i++) {
            if (!timeline.get(i).equals(timeline.get(i - 1))) {
                gantt.add(new String[]{
                        timeline.get(i - 1),
                        String.valueOf(start),
                        String.valueOf(i)
                });
                start = i;
            }
        }

        gantt.add(new String[]{
                timeline.get(timeline.size() - 1),
                String.valueOf(start),
                String.valueOf(timeline.size())
        });

        // ---- Display Table ----
        System.out.println("\nPID\tAT\tBT\tWT\tTAT");

        for (int i = 0; i < n; i++) {
            System.out.println("P" + processes[i][0] + "\t" +
                    processes[i][1] + "\t" +
                    processes[i][2] + "\t" +
                    wt[i] + "\t" +
                    tat[i]);
        }

        // ---- Averages ----
        double avgWT = 0, avgTAT = 0;

        for (int i = 0; i < n; i++) {
            avgWT += wt[i];
            avgTAT += tat[i];
        }

        System.out.println("\nAverage WT = " + String.format("%.2f", avgWT / n));
        System.out.println("Average TAT = " + String.format("%.2f", avgTAT / n));

        // ---- Gantt Chart ----
        System.out.println("\nGantt Chart:\n");

        int width = 7;

        // Process blocks
        for (String[] g : gantt) {
            System.out.printf("|%" + (width - 1) + "s", center(g[0], width - 1));
        }
        System.out.println("|");

        // Time line
        for (String[] g : gantt) {
            System.out.printf("%-" + width + "s", g[1]);
        }
        System.out.println(gantt.get(gantt.size() - 1)[2]);

        sc.close();
    }

    // Helper function to center text
    public static String center(String text, int width) {
        int pad = width - text.length();
        int left = pad / 2;
        int right = pad - left;
        return " ".repeat(left) + text + " ".repeat(right);
    }
}