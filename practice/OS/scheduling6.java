package practice.OS;
import java.util.*;

public class scheduling6 {


        public static void lruSimulation(int[] ref, int framesCount) {

            int[] frames = new int[framesCount];
            Arrays.fill(frames, -1);  // Initialize frames

            List<Integer> recent = new ArrayList<>(); // Track recent usage
            List<int[]> history = new ArrayList<>();
            List<String> stat = new ArrayList<>();

            int faults = 0;

            for (int page : ref) {

                if (!contains(frames, page)) {

                    int idx;

                    // If empty frame exists
                    if (contains(frames, -1)) {
                        idx = indexOf(frames, -1);
                    } else {
                        // Remove least recently used page
                        int lru = recent.remove(0);
                        idx = indexOf(frames, lru);
                    }

                    frames[idx] = page;
                    faults++;
                    stat.add("F");

                } else {
                    stat.add("H");
                    recent.remove((Integer) page); // Update recent usage
                }

                recent.add(page);
                history.add(frames.clone());
            }

            // ===== PRINT TABLE =====
            System.out.println("\nLRU Page Replacement\n");

            System.out.print("Ref : ");
            for (int p : ref) {
                System.out.printf("%3d", p);
            }
            System.out.println();

            System.out.println("-".repeat(6 + 3 * ref.length));

            for (int i = 0; i < framesCount; i++) {
                System.out.print("F" + (i + 1) + " : ");
                for (int[] step : history) {
                    if (step[i] == -1) {
                        System.out.print("  -");
                    } else {
                        System.out.printf("%3d", step[i]);
                    }
                }
                System.out.println();
            }

            System.out.println("-".repeat(6 + 3 * ref.length));

            System.out.print("Stat: ");
            for (String s : stat) {
                System.out.printf("%3s", s);
            }

            System.out.println("\n\nTotal Page Faults = " + faults);
        }

        // Helper function to check presence
        static boolean contains(int[] arr, int x) {
            for (int i : arr)
                if (i == x)
                    return true;
            return false;
        }

        // Helper function to get index
        static int indexOf(int[] arr, int x) {
            for (int i = 0; i < arr.length; i++)
                if (arr[i] == x)
                    return i;
            return -1;
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter reference string (space separated): ");
            String[] input = sc.nextLine().split(" ");

            int[] ref = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                ref[i] = Integer.parseInt(input[i]);
            }

            System.out.print("Enter number of frames: ");
            int frames = sc.nextInt();

            lruSimulation(ref, frames);

            sc.close();
        }
    }
