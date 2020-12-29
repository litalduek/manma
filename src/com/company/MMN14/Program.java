package com.company.MMN14;


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Program {

    private final int K; // to update this according to C !!!
    private final int m; // to update this according to C !!!
    private int[] hashArr; //check if this is the correct size
    private int[] hashTestArr;
    private Hasher hasher;


    public Program(int K,int M){
        this.K =K;
        this.m =M;
        hashArr = new int[this.m - 1];
        this.hasher = new Hasher(m);
    }

    public void hasher(String[] data){
        int index;
        for (int i = 0; i < data.length; i++) {
            int key = Integer.parseInt(data[i]);
                index = hasher.hashDivider(key);
                hashArr[index] = 1;
                if(K>1){
                    index = hasher.hashMultiplier(key);
                    hashArr[index] = 1;
                }
            }
    }

    public void printHashTable(){
        System.out.println("Hash table indexes:");
        for (int j = 0; j < hashArr.length; j++){
            if(hashArr[j]==1){
                System.out.print(j+",");
            }
        }
        System.out.println("Hash table indexes:");
    }

//    public void insertFile(String path){
//        String data = uploadFile(path);
//        hasher(data.split(","));
//    }

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