package com.company.MMN14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        program algo = new program();
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long m;
        do{
            System.out.println("Enter table size m");
            m =  scanner.nextLong();
        }while(m>algo.M_SIZE);

        System.out.println("Table size is: " + m);

        int K;
        do{
            System.out.println("Enter hash size K");
            K =  scanner.nextInt();
        }while(K>algo.K_SIZE);

        System.out.println("Hash size K: " + K);

        System.out.println("Would you like to Inserting or Checking?");
        String ans = br.readLine().toLowerCase();

        switch (ans){
            case "inserting":

                System.out.println("Enter your new file path");
                String path = br.readLine();
                System.out.println("Your file path: " +path);
                algo.updloadFile(path);

            case "checking":

            default: System.out.println("you can only insert or check the file");
        }

        System.out.println("Bye :)");
    }
}
