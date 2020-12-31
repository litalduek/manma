package com.company.MMN14;


import com.sangupta.murmur.Murmur3;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Program {

    private final int K; // to update this according to C !!!
    private final int m; // to update this according to C !!!
    private int[] hashArr; //check if this is the correct size

    public Program(int K,int M){
        this.K =K;
        this.m =M;
        this.hashArr = new int[m-1];
    }

    public int[] hasher(String[] data){
        int index;
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j <= K; j++) {
                index = Math.abs((int)Murmur3.hash_x86_32(data[i].getBytes(),data[i].length(),j))%m;
                hashArr[index] = 1;
            }
        }
        return hashArr;
    }

    public void compareArrays(String[] testData){
        int index;
        for (int i = 0; i < testData.length; i++) {
            boolean ok = true;
            for (int j = 1; j <= K; j++) {
                index = Math.abs((int)Murmur3.hash_x86_32(testData[i].getBytes(),testData[i].length(),j))%m;
                if(hashArr[index]==0){
                    ok=!ok;
                    break;
                }
            }
            if(!ok){
                System.out.println(testData[i] + " not belongs to the structure");
            }
        }
    }

    public void printHashTable(int[] arr){
        System.out.println("Hash table indexes:");
        for (int j = 0; j < arr.length; j++){
            if(arr[j]==1){
                System.out.print(j+",");
            }
        }
        System.out.println();
    }

    public String uploadFile(String filePath) {
        String data = "";
        try {
            File file = new File(filePath);
            Scanner myReader = new Scanner(file);
            System.out.println("Data keys:");
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return data;
    }

}