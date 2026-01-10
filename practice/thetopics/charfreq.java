package practice.thetopics;

public class charfreq {
    public static void main(String[] args) {


        String s = "banana";
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }


        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                System.out.println((char)(i + 'a') + " -> " + freq[i]);
            }
        }

        // First non repeating character
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                System.out.println(s.charAt(i));
                break;
            }
        }


        // Check Duplicate Characters
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 1) {
                System.out.println((char)(i + 'a') + " is duplicate");
            }
        }


        // Count Distinct Characters
        int distinct = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) distinct++;
        }
        System.out.println(distinct);


    }
}
