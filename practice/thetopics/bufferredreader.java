package practice.thetopics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class bufferredreader {
    public static void main(String[] args ) throws IOException {

        System.out.println("Enter a number ");


        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader Bf = new BufferedReader(in);

        int num = Integer.parseInt(Bf.readLine());
        System.out.println(num);

        Bf.close();
    }
}