package practice.basics;

//Sum of Digits
//
//Write a Java program and compute the sum of an integer's digits.
//Input Data:
//Input an integer: 25

import java.util.Scanner;


public class problem8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long n = input.nextLong();

        System.out.println("the sum of digits is :" + sumDigits(n));
    }

    public static int sumDigits(long n) {
        int sum = 0;
        while (n != 0) {
            sum = (int) (sum + n % 10);
            n /= 10;


        }
        return sum;


    }
}
