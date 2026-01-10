package practice.thetopics;

public class stringbuilder {
    public static void main(String[] args) {

        String s = "hello";

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        System.out.println(sb.toString());
    }
}




