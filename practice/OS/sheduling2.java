package practice.OS;
import java.util.*;

public class sheduling2 {
    // Shortest Job First Scheduling (Non-Preemptive)

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of processes: ");
            int n = sc.nextInt();

            int[][] processes = new int[n][3]; // [pid, arrival time, burst time]

            // Input
            for (int i = 0; i < n; i++) {
                processes[i][0] = i + 1;

                System.out.print("Enter arrival time of P" + (i + 1) + ": ");
                processes[i][1] = sc.nextInt();

                System.out.print("Enter burst time of P" + (i + 1) + ": ");
                processes[i][2] = sc.nextInt();
            }

            int completed = 0;
            int currentTime = 0;

            double totalWT = 0, totalTAT = 0;
            boolean[] isCompleted = new boolean[n];

            System.out.println("\nProcess\tAT\tBT\tCT\tWT\tTAT");

            while (completed != n) {
                int idx = -1;
                int minBT = Integer.MAX_VALUE;

                // Find shortest job among arrived processes
                for (int i = 0; i < n; i++) {
                    if (processes[i][1] <= currentTime &&
                            !isCompleted[i] &&
                            processes[i][2] < minBT) {

                        minBT = processes[i][2];
                        idx = i;
                    }
                }

                if (idx == -1) {
                    currentTime++; // CPU idle
                } else {
                    int pid = processes[idx][0];
                    int at = processes[idx][1];
                    int bt = processes[idx][2];

                    int ct = currentTime + bt;
                    int tat = ct - at;
                    int wt = tat - bt;

                    currentTime = ct;
                    isCompleted[idx] = true;
                    completed++;

                    totalWT += wt;
                    totalTAT += tat;

                    System.out.println("P" + pid + "\t" + at + "\t" + bt + "\t" + ct + "\t" + wt + "\t" + tat);
                }
            }

            System.out.println("\nAverage Waiting Time = " + (totalWT / n));
            System.out.println("Average Turnaround Time = " + (totalTAT / n));

            sc.close();
        }
    }

