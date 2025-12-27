package practice.basics;
//Unique Three-Digit Numbers
//
//Write a Java program to create and display a unique three-digit number using 1, 2, 3, 4. Also count how many three-digit numbers are there.
//Expected Output
//
//123
//124
//...
//
//431
//432
//Total number of the three-digit-number is 24

public class problem9 {
    public static void main(String[] args) {
        int amount = 0;
        int noonum = 0;


        for (int i = 1; i <= 4 ; i++){
            for (int j = 1; j <= 4 ; j++){
                for (int k = 1; k <= 4 ; k++){
                    amount++;
                    if(i != j && i != k && k != j){
                        noonum++;
                        System.out.println(i + "" + j + "" + k);

                    }
                }
            }

        }

        System.out.println("the total no of times loop ran " + amount);
        System.out.println("the total no of numbers " + noonum);

    }
}
// pehle code de samjhne ki koshish kar for neeche padhna
// ye code me apan ne seekha ki nested loop me sabse andar waala loop sabse fast hota hai ya apan keh sakte hai ki sabse zayada baar chalta hai ......baki mere bhai tu khud samajhdaar hai .