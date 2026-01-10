package practice.thetopics;

public class reverse {
    public static void main(String[] args) {
        /*
        * dorect method */
        String s = "Atharv";

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        System.out.println(sb);



        // loop se reverse karne waali technique

        String c = "Atharv";

        StringBuilder cb = new StringBuilder();

        for(int i = c.length() - 1; i >= 0; i--){
            cb.append(c.charAt(i));
        }
        System.out.println(cb);

    }
    
}
