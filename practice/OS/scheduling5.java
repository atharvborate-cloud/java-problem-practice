package practice.OS;
import java.util.*;

public class scheduling5 {


        public static void fifoSimulation(int[] referenceString, int framesCount) {

            int[] frames = new int[framesCount];
            Arrays.fill(frames, -1);  // Initialize frames with -1

            Queue<Integer> queue = new LinkedList<>(); // To track FIFO order
            int pageFaults = 0;

            List<int[]> history = new ArrayList<>();
            List<String> faults = new ArrayList<>();

            for (int page : referenceString) {

                boolean hit = false;

                // Check if page is already present (HIT)
                for (int f : frames) {
                    if (f == page) {
                        hit = true;
                        break;
                    }
                }

                if (!hit) {
                    int idx = -1;

                    // Check for empty frame
                    for (int i = 0; i < framesCount; i++) {
                        if (frames[i] == -1) {
                            idx = i;
                            break;
                        }
                    }

                    if (idx != -1) {
                        // Empty frame available
                        frames[idx] = page;
                        queue.add(idx);
                    } else {
                        // Replace oldest page (FIFO)
                        idx = queue.poll();
                        frames[idx] = page;
                        queue.add(idx);
                    }

                    pageFaults++;
                    faults.add("F");  // Fault
                } else {
                    faults.add("H");  // Hit
                }

                history.add(frames.clone());
            }

            // ===== PRINT TABLE =====
            System.out.println("\nFIFO Page Replacement Table\n");

            // Reference string
            System.out.print("Ref : ");
            for (int p : referenceString) {
                System.out.printf("%3d", p);
            }
            System.out.println();

            System.out.println("-".repeat(6 + 3 * referenceString.length));

            // Frames
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

            System.out.println("-".repeat(6 + 3 * referenceString.length));

            // Hit/Fault Status
            System.out.print("Stat: ");
            for (String f : faults) {
                System.out.printf("%3s", f);
            }
            System.out.println();

            System.out.println("\nTotal Page Faults = " + pageFaults);
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter reference string (space separated): ");
            String[] input = sc.nextLine().split(" ");

            int[] reference = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                reference[i] = Integer.parseInt(input[i]);
            }

            System.out.print("Enter number of frames: ");
            int frames = sc.nextInt();

            fifoSimulation(reference, frames);

            sc.close();
        }
    }

