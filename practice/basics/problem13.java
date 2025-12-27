// numbers divisible by 3 and 5 between 1 to 100




package practice.basics;
import java.util.Scanner;

public class problem13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n ;
        int m;

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i <= 100; i++) {
            if (i % n == 0 && i % m == 0){
                System.out.print(i);
                System.out.print(" ");
                System.out.print(",");
            }
        }


    }
}
