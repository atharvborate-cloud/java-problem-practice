package practice.OS;
import java.util.*;

public class scheduling3b {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of processes: ");
            int n = sc.nextInt();

            // [pid, at, bt, priority, remaining time]
            int[][] processes = new int[n][5];

            for (int i = 0; i < n; i++) {
                int pid = i + 1;

                System.out.print("Enter Arrival Time for P" + pid + ": ");
                int at = sc.nextInt();

                System.out.print("Enter Burst Time for P" + pid + ": ");
                int bt = sc.nextInt();

                System.out.print("Enter Priority for P" + pid + " (lower = higher): ");
                int pr = sc.nextInt();

                processes[i][0] = pid;
                processes[i][1] = at;
                processes[i][2] = bt;
                processes[i][3] = pr;
                processes[i][4] = bt; // remaining time
            }

            int time = 0, completed = 0;
            int[] wt = new int[n];
            int[] tat = new int[n];

            List<String> timeline = new ArrayList<>();

            // Scheduling
            while (completed < n) {
                int idx = -1;
                int highestPriority = Integer.MAX_VALUE;

                for (int i = 0; i < n; i++) {
                    if (processes[i][1] <= time && processes[i][4] > 0) {

                        if (processes[i][3] < highestPriority) {
                            highestPriority = processes[i][3];
                            idx = i;
                        }
                    }
                }

                if (idx == -1) {
                    timeline.add("Idle");
                    time++;
                    continue;
                }

                // Execute 1 unit
                processes[idx][4]--;
                timeline.add("P" + processes[idx][0]);
                time++;

                // Completion
                if (processes[idx][4] == 0) {
                    completed++;

                    int pid = processes[idx][0];
                    int at = processes[idx][1];
                    int bt = processes[idx][2];

                    tat[pid - 1] = time - at;
                    wt[pid - 1] = tat[pid - 1] - bt;
                }
            }

            // Convert timeline → Gantt
            List<String[]> gantt = new ArrayList<>();
            int start = 0;

            for (int i = 1; i < timeline.size(); i++) {
                if (!timeline.get(i).equals(timeline.get(i - 1))) {
                    gantt.add(new String[]{timeline.get(i - 1), String.valueOf(start), String.valueOf(i)});
                    start = i;
                }
            }

            gantt.add(new String[]{
                    timeline.get(timeline.size() - 1),
                    String.valueOf(start),
                    String.valueOf(timeline.size())
            });

            // Table
            System.out.println("\nPID\tAT\tBT\tPR\tWT\tTAT");
            for (int i = 0; i < n; i++) {
                System.out.println("P" + processes[i][0] + "\t" +
                        processes[i][1] + "\t" +
                        processes[i][2] + "\t" +
                        processes[i][3] + "\t" +
                        wt[i] + "\t" + tat[i]);
            }

            // Averages
            double avgWT = 0, avgTAT = 0;
            for (int i = 0; i < n; i++) {
                avgWT += wt[i];
                avgTAT += tat[i];
            }

            System.out.println("\nAverage WT = " + String.format("%.2f", avgWT / n));
            System.out.println("Average TAT = " + String.format("%.2f", avgTAT / n));

            // Gantt Chart
            System.out.println("\nGantt Chart:\n");

            int width = 7;
            for (String[] block : gantt) {
                System.out.printf("|%" + (width - 1) + "s", center(block[0], width - 1));
            }
            System.out.println("|");

            for (String[] block : gantt) {
                System.out.printf("%-" + width + "s", block[1]);
            }
            System.out.println(gantt.get(gantt.size() - 1)[2]);

            sc.close();
        }

        // Center helper
        public static String center(String text, int width) {
            int padding = width - text.length();
            int left = padding / 2;
            int right = padding - left;
            return " ".repeat(left) + text + " ".repeat(right);
        }
    }
