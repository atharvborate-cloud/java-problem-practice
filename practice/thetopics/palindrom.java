package practice.thetopics;

public class palindrom {
    public static void main(String[] args) {
       /* String S = "madam";

        StringBuilder sb = new StringBuilder();

        for(int i = S.length() - 1 ; i >= 0 ; i--){
            sb.append(S.charAt(i));

        }
        System.out.println(sb);

        */

        String s = "madam";

        int left = 0;
        int right = s.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println(isPalindrome);



    }
}

// bass isme if else laga do aur input le lo , if else se check kar lo, ho gaye