package practice.OS;
import java.util.*;

public class scheduling9 {


        static void checkSafety(String[] p, int[] avail, int[][] max, int[][] alloc) {

            int n = p.length;
            int m = avail.length;

            int[][] need = new int[n][m];

            // Calculate Need Matrix
            System.out.println("Need Matrix:");
            for (int i = 0; i < n; i++) {
                System.out.print(p[i] + ": ");
                for (int j = 0; j < m; j++) {
                    need[i][j] = max[i][j] - alloc[i][j];
                    System.out.print(need[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("\nProcess-wise Safety Check:\n");

            // Check each process individually
            for (int i = 0; i < n; i++) {

                System.out.println("Checking " + p[i] + ":");

                boolean safe = true;

                for (int j = 0; j < m; j++) {
                    if (need[i][j] > avail[j]) {
                        safe = false;
                        break;
                    }
                }

                if (safe)
                    System.out.println(p[i] + " is Safe\n");
                else
                    System.out.println(p[i] + " is Unsafe\n");
            }
        }

        public static void main(String[] args) {

            String[] processes = {"P0", "P1", "P2", "P3", "P4"};

            int[] available = {3, 3, 2};

            int[][] max = {
                    {7, 5, 3},
                    {3, 2, 2},
                    {9, 0, 2},
                    {2, 2, 2},
                    {4, 3, 3}
            };

            int[][] alloc = {
                    {0, 1, 0},
                    {2, 0, 0},
                    {3, 0, 2},
                    {2, 1, 1},
                    {0, 0, 2}
            };

            checkSafety(processes, available, max, alloc);
        }
    }
