package practice.OS;
import java.util.*;

public class scheduling3 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of processes: ");
            int n = sc.nextInt();

            List<int[]> processes = new ArrayList<>();
            // [pid, arrival time, burst time, priority]

            // Input
            for (int i = 0; i < n; i++) {
                int pid = i + 1;

                System.out.print("Enter Arrival Time for P" + pid + ": ");
                int at = sc.nextInt();

                System.out.print("Enter Burst Time for P" + pid + ": ");
                int bt = sc.nextInt();

                System.out.print("Enter Priority for P" + pid + " (lower = higher priority): ");
                int pr = sc.nextInt();

                processes.add(new int[]{pid, at, bt, pr});
            }

            // Sort by arrival time
            processes.sort(Comparator.comparingInt(a -> a[1]));

            int time = 0;
            List<int[]> completed = new ArrayList<>();
            int[] waitingTime = new int[n];
            int[] turnaroundTime = new int[n];

            List<int[]> gantt = new ArrayList<>(); // [pid, start, end]

            while (!processes.isEmpty()) {

                List<int[]> available = new ArrayList<>();

                // Find available processes
                for (int[] p : processes) {
                    if (p[1] <= time) {
                        available.add(p);
                    }
                }

                if (available.isEmpty()) {
                    time++; // CPU idle
                    continue;
                }

                // Sort by priority (lower number = higher priority)
                available.sort(Comparator.comparingInt(a -> a[3]));

                int[] current = available.get(0);

                int pid = current[0];
                int at = current[1];
                int bt = current[2];

                waitingTime[pid - 1] = time - at;

                // Gantt entry
                gantt.add(new int[]{pid, time, time + bt});

                time += bt;

                turnaroundTime[pid - 1] = waitingTime[pid - 1] + bt;

                completed.add(current);
                processes.remove(current);
            }

            // Output Table
            System.out.println("\nPID\tAT\tBT\tPR\tWT\tTAT");

            for (int[] p : completed) {
                int pid = p[0], at = p[1], bt = p[2], pr = p[3];

                System.out.println("P" + pid + "\t" + at + "\t" + bt + "\t" + pr + "\t"
                        + waitingTime[pid - 1] + "\t" + turnaroundTime[pid - 1]);
            }

            // Averages
            double avgWT = 0, avgTAT = 0;

            for (int i = 0; i < n; i++) {
                avgWT += waitingTime[i];
                avgTAT += turnaroundTime[i];
            }

            avgWT /= n;
            avgTAT /= n;

            System.out.println("\nAverage Waiting Time = " + String.format("%.2f", avgWT));
            System.out.println("Average Turnaround Time = " + String.format("%.2f", avgTAT));

            // Gantt Chart
            System.out.println("\nGantt Chart:");

            for (int[] g : gantt) {
                System.out.print("|  P" + g[0] + "  ");
            }
            System.out.println("|");

            System.out.print(gantt.get(0)[1] + " ");
            for (int[] g : gantt) {
                System.out.print("    " + g[2] + " ");
            }
            System.out.println();

            sc.close();
        }
    }
