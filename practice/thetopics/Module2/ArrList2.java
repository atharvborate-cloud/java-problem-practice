package practice.thetopics.Module2;
import java.util.ArrayList;
import java.util.Collections;

public class ArrList2 {
    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(5); nums.add(2); nums.add(8); nums.add(1);

        Collections.sort(nums);           // [1, 2, 5, 8]
        Collections.reverse(nums);        // [8, 5, 2, 1]
        Collections.shuffle(nums);        // random order
        System.out.println(Collections.min(nums));  // smallest
        System.out.println(Collections.max(nums));  // largest
        Collections.swap(nums, 0, 1);     // swap index 0 and 1
    }
}
