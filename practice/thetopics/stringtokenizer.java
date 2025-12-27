package practice.thetopics;

import java.util.StringTokenizer;

public class stringtokenizer {
    public static void main(String[] args) {
        String s = "they dont know me son";
        StringTokenizer st = new StringTokenizer(s);

        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());

        }
    }

}
