package com.company.MMN14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Documented;
import java.util.Scanner;

public class Program {

    static final int K_MAX_SIZE = 13;
    static final int M_MAX_SIZE = 32*(10^6);
    static Algo algo;
    static Scanner scanner = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * This method processes the user's request to insert a file into the structure or check the file's affiliation to the structure
     * @param ans option selected by the user
     * */
    public static void program(String ans) throws IOException {
            if(ans.equals("insert")) {
                System.out.println("Enter your new file path");
                String insertFilePath = br.readLine();
//                String insertFilePath="C:/Users/User/Desktop/CS/מבני נתונים ומבוא לאלגוריתמים/MMN14/insertionfile.txt";
                System.out.println("Your file path: " + insertFilePath);
                String[] data = algo.uploadFile(insertFilePath,"Data keys are:");
                algo.hasher(data,false);
                algo.printHashTable();
            }
            else if(ans.equals("check")) {
                System.out.println("Enter your test file path");
                String testFilePath = br.readLine();
//                String testFilePath="C:/Users/User/Desktop/CS/מבני נתונים ומבוא לאלגוריתמים/MMN14/testfile.txt";
                System.out.println("Your file path: " + testFilePath);
                String[] testData = algo.uploadFile(testFilePath, "Test file data keys are: ");
                algo.hasher(testData,true);
            }
    }

    /**
     * The program captures the k and m parameters from the user and asks if you want to insert or test the structure.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int m;
        do{
            System.out.println("Enter table size m");
            m =  scanner.nextInt();
//            m=701;
        }while(m> M_MAX_SIZE);

        System.out.println("Table size is: " + m);

        int K;
        do{
            System.out.println("Enter hash size K");
            K =  scanner.nextInt();
//            K=4;
        }while(K> K_MAX_SIZE);

        System.out.println("Hash size K: " + K);
         algo = new Algo(K, m);

        String ans;
        do{
            System.out.println("Would you like to Insert or Check?");
            ans = br.readLine().toLowerCase();
            program(ans);
        }while(!ans.equals("exit"));
    }

}
