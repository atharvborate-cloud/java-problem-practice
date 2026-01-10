package practice.thetopics;

public class charAtbruhh {
    public static void main(String[] args) {
        String s = "Atharv";

        for (int i = 0; i < s.length();i++){
//            System.out.print(s.charAt(i) + " " + "and" + " "); ye ek tarreka hai but not used in dsa and cp
            char ch = s.charAt(i);
            System.out.println(ch + " " + "and" );

        }

        String part = s.substring(0,4);
        System.out.println(part);


    }
}
