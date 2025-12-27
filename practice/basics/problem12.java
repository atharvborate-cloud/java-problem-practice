// Compute n+nn+nnn

//Write a Java program that accepts an integer (n) and computes the value of n+nn+nnn./
//Sample Output:

//Input number: 5
//        5 + 55  + 555




package practice.basics;

 import java.util.Scanner;

public class problem12 {
    public static void main(String []args){
        int n;
        Scanner num = new Scanner(System.in);
        n = num.nextInt();
        System.out.println( n + n*10 + n + n*100 + n*10 +n );




    }
}
