package practice.OS;
import java.util.*;

public class scheduling7 {


        // First Fit Algorithm
        static int[] firstFit(int[] blocks, int[] processes) {
            int[] alloc = new int[processes.length];
            Arrays.fill(alloc, -1);

            for (int i = 0; i < processes.length; i++) {
                for (int j = 0; j < blocks.length; j++) {
                    if (blocks[j] >= processes[i]) {
                        alloc[i] = j;
                        blocks[j] -= processes[i];
                        break;
                    }
                }
            }
            return alloc;
        }

        // Best Fit Algorithm
        static int[] bestFit(int[] blocks, int[] processes) {
            int[] alloc = new int[processes.length];
            Arrays.fill(alloc, -1);

            for (int i = 0; i < processes.length; i++) {
                int best = -1;

                for (int j = 0; j < blocks.length; j++) {
                    if (blocks[j] >= processes[i] &&
                            (best == -1 || blocks[j] < blocks[best])) {
                        best = j;
                    }
                }

                if (best != -1) {
                    alloc[i] = best;
                    blocks[best] -= processes[i];
                }
            }
            return alloc;
        }

        // Worst Fit Algorithm
        static int[] worstFit(int[] blocks, int[] processes) {
            int[] alloc = new int[processes.length];
            Arrays.fill(alloc, -1);

            for (int i = 0; i < processes.length; i++) {
                int worst = -1;

                for (int j = 0; j < blocks.length; j++) {
                    if (blocks[j] >= processes[i] &&
                            (worst == -1 || blocks[j] > blocks[worst])) {
                        worst = j;
                    }
                }

                if (worst != -1) {
                    alloc[i] = worst;
                    blocks[worst] -= processes[i];
                }
            }
            return alloc;
        }

        // Print Result
        static void printResult(int[] alloc, int[] processes) {
            System.out.println("\nProcess\tSize\tBlock");

            for (int i = 0; i < processes.length; i++) {
                System.out.println((i + 1) + "\t" + processes[i] + "\t" +
                        (alloc[i] != -1 ? (alloc[i] + 1) : "Not Allocated"));
            }
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter memory blocks (space separated): ");
            int[] blocks = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            System.out.print("Enter processes (space separated): ");
            int[] processes = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            System.out.println("\n--- First Fit ---");
            printResult(firstFit(blocks.clone(), processes), processes);

            System.out.println("\n--- Best Fit ---");
            printResult(bestFit(blocks.clone(), processes), processes);

            System.out.println("\n--- Worst Fit ---");
            printResult(worstFit(blocks.clone(), processes), processes);

            sc.close();
        }
    }

