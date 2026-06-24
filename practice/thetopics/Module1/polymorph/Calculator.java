package practice.thetopics.Module1.polymorph;

//Method Overloading ....Compile time

public class Calculator {

    public int add (int a , int b ){
        return a + b;
    }

    public double add (double a , double b ){
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        Calculator c  = new Calculator();
        System.out.println(c.add(2,3));      // java automatically by default int ko call karega agar int value hai toh
        System.out.println(c.add(2.3,3.4)); // java automatically double ko call karega
        System.out.println(c.add(2,3,3));// abb isme 3 values hai toh teen values waale method ko call karega
                                                      //------> aur ye sab compilation ke time pe hota hai



    }

}
