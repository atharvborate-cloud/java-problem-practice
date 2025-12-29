package practice.thetopics;

import java.util.Scanner;

public class prefixarray2 {


    static void printarray(int[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    static int[] makeprefix(int[] arr){
        int n = arr.length;


        for(int i = 1; i<n; i++){
            arr[i] = arr[i - 1] + arr[i];
        }

        return arr;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an array");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter" + n + "elements");
        for(int i = 1; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Input Array");
        printarray(arr);

        int[] prefix = makeprefix(arr);
        printarray(prefix);


    }

}


