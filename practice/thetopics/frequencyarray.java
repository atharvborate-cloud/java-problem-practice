package practice.thetopics;

public class frequencyarray {
    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 4, 5, 2, 7, 2 };


        int max = 7;
        int[] freq = new int[max + 1];

        for(int i = 0; i < arr.length; i++){
            freq[arr[i]]++;
        }

        for (int i = 0; i< freq.length; i++){
            if(freq[i] > 0 ){
                System.out.println(i + "occurs" + freq[i] + "times");
            }

        }


    }


}
