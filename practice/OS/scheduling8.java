package practice.OS;
import java.util.*;
public class scheduling8 {


        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of processes: ");
            int n = sc.nextInt();

            System.out.print("Enter number of resource types: ");
            int m = sc.nextInt();

            int[][] alloc = new int[n][m];
            int[][] max = new int[n][m];
            int[][] need = new int[n][m];
            int[] avail = new int[m];

            // Input Allocation Matrix
            System.out.println("\nEnter Allocation Matrix:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    alloc[i][j] = sc.nextInt();
                }
            }

            // Input Maximum Matrix
            System.out.println("\nEnter Maximum Matrix:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    max[i][j] = sc.nextInt();
                }
            }

            // Input Available Resources
            System.out.println("\nEnter Available Resources:");
            for (int j = 0; j < m; j++) {
                avail[j] = sc.nextInt();
            }

            // Calculate Need = Max - Allocation
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    need[i][j] = max[i][j] - alloc[i][j];
                }
            }

            // Safety Algorithm
            boolean[] finish = new boolean[n];
            int[] work = avail.clone();
            List<Integer> safeSeq = new ArrayList<>();

            while (safeSeq.size() < n) {

                boolean found = false;

                for (int i = 0; i < n; i++) {

                    if (!finish[i]) {

                        boolean possible = true;

                        for (int j = 0; j < m; j++) {
                            if (need[i][j] > work[j]) {
                                possible = false;
                                break;
                            }
                        }

                        if (possible) {
                            for (int j = 0; j < m; j++) {
                                work[j] += alloc[i][j];
                            }

                            safeSeq.add(i);
                            finish[i] = true;
                            found = true;
                        }
                    }
                }

                if (!found) break;
            }

            // Output Result
            if (safeSeq.size() == n) {
                System.out.println("\nSystem is in SAFE state");
                System.out.print("Safe sequence: ");
                for (int i : safeSeq) {
                    System.out.print("P" + i + " ");
                }
            } else {
                System.out.println("\nSystem is NOT in SAFE state");
            }

            sc.close();
        }
    }

