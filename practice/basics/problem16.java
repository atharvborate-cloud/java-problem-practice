package practice.basics;

public class problem16 {
    public static void main(String[] args) {
        int[] num_array = {30 , 20 , 30 , 40 , 50, 70 , 20};

        boolean result = ((num_array[0] == 10  )  || (num_array[num_array.length - 1] == 10));

        System.out.println(result);
    }
}
