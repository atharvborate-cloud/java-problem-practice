package practice.OS;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SCHEDULING {
    // FCFS Scheduling with Arrival Time and Burst Time

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of processes: ");
            int n = sc.nextInt();

            int[][] processes = new int[n][3]; // [pid, arrival time, burst time]

            // Input
            for (int i = 0; i < n; i++) {
                processes[i][0] = i + 1; // PID

                System.out.print("Enter arrival time of P" + (i + 1) + ": ");
                processes[i][1] = sc.nextInt();

                System.out.print("Enter burst time of P" + (i + 1) + ": ");
                processes[i][2] = sc.nextInt();
            }

            // Sort by Arrival Time
            Arrays.sort(processes, Comparator.comparingInt(a -> a[1]));

            int currentTime = 0;
            double totalWT = 0, totalTAT = 0;

            System.out.println("\nProcess\tAT\tBT\tCT\tWT\tTAT");

            for (int i = 0; i < n; i++) {
                int pid = processes[i][0];
                int at = processes[i][1];
                int bt = processes[i][2];

                // CPU idle condition
                if (currentTime < at) {
                    currentTime = at;
                }

                int ct = currentTime + bt; // Completion Time
                int tat = ct - at;         // Turnaround Time
                int wt = tat - bt;         // Waiting Time

                currentTime = ct;

                totalWT += wt;
                totalTAT += tat;

                System.out.println("P" + pid + "\t" + at + "\t" + bt + "\t" + ct + "\t" + wt + "\t" + tat);
            }

            System.out.println("\nAverage Waiting Time = " + (totalWT / n));
            System.out.println("Average Turnaround Time = " + (totalTAT / n));

            sc.close();
        }
    }

