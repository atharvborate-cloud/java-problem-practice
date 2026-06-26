package practice.thetopics.Module2;
import java.util.ArrayList;

public class ArrList {
    public static void main(String[] args) {

        // Creating
        ArrayList<String> student = new ArrayList<>();

        // Adding
        student.add("Atharv");
        student.add("Rahul");
        student.add("Priya");
        student.add("virat");


        //Accessing

        System.out.println(student.get(0));  // Atharv
        System.out.println(student.size());  // Array list ka size which is four 4


        //updating
        student.set(1 , "rohit");

        //removing

        student.remove("Priya");      // using Value
        student.remove(4);         // Using Index

        //Looping -->>> There are three ways

        //way 1 for loop

        for(int i = 0; i < student.size(); i++ ){
            System.out.println(student.get(i));
        }

        // way 2 for each loop
        for( String s : student){
            System.out.println(s);
        }

        //way 3 for each with lambda
        student.forEach(s -> System.out.println(s));

        // checking
        System.out.println(student.contains("Atharv"));     // true
        System.out.println(student.isEmpty());              // False

        //sorting
        java.util.Collections.sort(student);
        System.out.println(student);


    }


}
