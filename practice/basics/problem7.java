package practice.basics;

//Compare two integers............

import java.util.Scanner;

public class problem7 {
    public static void main(String[] args) {
        Scanner num =  new Scanner(System.in);

        int a;
        int b;

        System.out.println("Enter the first number :");
        a = num.nextInt();

        System.out.println("Enter the Second number :");
        b = num.nextInt();

        if(a>b){
            System.out.println(a + "is grater than" + b );

        }
        else if(a==b)
            System.out.println("both are eaqual ");


        else
            System.out.println(b + "is grater than" + a);



    }
}
