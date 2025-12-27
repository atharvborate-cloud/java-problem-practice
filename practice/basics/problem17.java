package practice.basics;

public class problem17 {
    public static void main(String[] args) {
        int[] arr = {10, 27, 13, 56, 67, 78, 40};
        int[] arr2 = {10, 30, 45, 78, 34, 67, 40};

        if (arr.length >= 2 && arr2.length >= 2) {
            System.out.println(arr[0] == arr2[0] || arr[arr.length - 1] == arr2[arr2.length - 1]);
        }

        else {
            System.out.println("array length less than 2");

        }
     }
}





//System.out.println(arr[0] == arr2[0] || arr[arr.length - 1] == arr2[arr2.length - 1]);
//iske andar ye jo hai (arr[0] == arr2[0] || arr[arr.length - 1] == arr2[arr2.length - 1]); ye ek boolean ecpression hai toh sout true ya false he print karega
