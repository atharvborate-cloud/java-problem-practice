package practice.thetopics;

public class arraypar {

    // ye niche (int[] a) jo diya hai humne as a parameter ye kar ke humne functuion ko array ka input lene ke kabil banaya hai
    // fir jo bhi input milega vo a mein save ho jayega .
    static void arraywaala( int[] a){
        for(int i = 0; i<a.length ; i++) {
            System.out.print(a[i] + " ");

        }

    }

    public static void main(String[] args) {
        int [] arr = {1,3,4,5,7,8};
        // ye apan e arr ka input de diya function me fuction static hai isliye object create karne ki zaroorat nahi padi
        arraywaala(arr);
    }

}
