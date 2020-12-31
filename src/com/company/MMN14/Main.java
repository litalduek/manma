package com.company.MMN14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static final int K_MAX_SIZE = 1000000; // to update this according to C !!!
    static final int M_MAX_SIZE = 1000000; //
    static Program algo;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m;
        do{
            System.out.println("Enter table size m");
//            m =  scanner.nextInt();
            m=701;
        }while(m> M_MAX_SIZE);

        System.out.println("Table size is: " + m);

        int K;
        do{
            System.out.println("Enter hash size K");
//            K =  scanner.nextInt();
            K=4;
        }while(K> K_MAX_SIZE);

        System.out.println("Hash size K: " + K);
         algo = new Program(K, m);

        System.out.println("Would you like to Insert or Check?");
        String ans = br.readLine().toLowerCase();

        switch (ans){
            case "insert":

                System.out.println("Enter your new file path");
//                String insertFilePath = br.readLine();
                String insertFilePath="C:/Users/User/Desktop/CS/מבני נתונים ומבוא לאלגוריתמים/MMN14/insertionfile.txt";
                System.out.println("Your file path: " +insertFilePath);
                String data = algo.uploadFile(insertFilePath);
                int[] hashArr = algo.hasher(data.split(","));
                algo.printHashTable(hashArr);

            case "check":
                System.out.println("Enter your test file path");
//                String testFilePath = br.readLine();
                String testFilePath="C:/Users/User/Desktop/CS/מבני נתונים ומבוא לאלגוריתמים/MMN14/testfile.txt";
                System.out.println("Your file path: " +testFilePath);
                String testData = algo.uploadFile(testFilePath);
                algo.compareArrays(testData.split(","));

            default: System.out.println("Would you like to Insert or Check?");
                ans = br.readLine().toLowerCase();
        }

        System.out.println("Bye :)");
    }
}
