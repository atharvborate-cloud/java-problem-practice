//Q:Java: Create a new string of 4 copies of the last 3 characters of the original string

package practice.basics;

public class problem15 {
    public static void main(String[] args) {
        String main_str = "wewon";
        System.out.println("original string :" + main_str);


        String last_three = main_str.substring(main_str.length() - 3);
        System.out.println(last_three + last_three +last_three );


    }

}
