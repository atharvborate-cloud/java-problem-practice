package practice.basics;
// Write a Java program to print the results of the following operations.
//Test Data:
//a. -5 + 8 * 6
//b. (55+9) % 9
//c. 20 + -3*5 / 8
//d. 5 + 15 / 3 * 2 - 8 % 3

public class problem1 {
    public static void main(String[] args) {
        //a.
        int a = 5;
        int b = 8;
        int c = 6;
        System.out.println(-a + b * c);

        //b.
        int d = 55;
        int e = 9;
        int f = 9;
        System.out.println((d + e) % f);

        //c.
        int ab = 20;
        int bc = 3;
        int cb = 5;
        int cd = 8;
        System.out.println(ab + (-bc * cb) / cd);

        //d.5 + 15 / 3 * 2 - 8 % 3
        int y = 15;
        int j = 2;
        System.out.println(cb + y / bc * j - cd % bc);


    }
}
