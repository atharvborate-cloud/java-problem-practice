package practice.basics;
//Reverse a String
//
//Write a Java program to reverse a string.
//Input Data:
//Input a string: The quick brown fox
//Expected Output
//
//Reverse string: xof nworb kciuq ehT


import java.util.Scanner;

public class problem6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("enter a string :");

        char[] letters = scanner.nextLine().toCharArray();

        System.out.println("Reversed string :");

        for(int i = letters.length - 1; i>=0 ; i--){
            System.out.print(letters[i]);
        }



    }
}

//. Your Way
//char[] letters = scanner.nextLine().toCharArray();
//
//
//What it does: Takes the whole line as a String, then immediately converts it into a character array.
//
//When useful:
//
//If your main goal is to work with each character individually (like reversing, checking palindromes, character counts).
//
//Downside: Creates an extra array in memory (not a big deal unless the string is huge).
//
//2. Just Taking the String
//String input = scanner.nextLine();
//
//
//Most common & simplest way to read a line of text.
//
//You can later convert it into a char[] only if needed:
//
//char[] letters = input.toCharArray();
//
//
//Preferred in most cases because you don’t always know if you’ll need character-level operations.
//
//3. Reading a Single Word
//String word = scanner.next();
//
//
//Reads only up to the first space.
//
//Example: input "Hello World" → word = "Hello".
//
//Good when you want tokens/words one by one.
//
//4. Using BufferedReader (faster for big input)
//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//String input = br.readLine();
//
//
//Used in competitive programming because it’s faster than Scanner.
//
//But more code to set up.
//
//✅ Best Practice
//
//For normal programs / assignments / learning:
//→ scanner.nextLine() (keep it as a String) is the best starting point.
//
//For character-level problems:
//→ use .toCharArray() after reading the string.
//
//For very large input / speed-sensitive tasks:
//→ use BufferedReader.
//
//👉 So your line is fine, but slightly overkill unless you know you need the array immediately.
//Usually we do:
//
//String input = scanner.nextLine();
//
//
//and then convert later if needed.
