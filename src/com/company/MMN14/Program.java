package com.company.MMN14;

import java.io.*;
import java.util.Scanner;

public class Program {

    public final int K_SIZE; // to update this according to C !!!
    public final int M_SIZE; // to update this according to C !!!
    public int[] hashArr; //check if this is the correct size
    public Murmur3HashFunction murmur;

    public Program(int K,int M){
        K_SIZE=K;
        M_SIZE=M;
        hashArr = new int[M_SIZE - 1];
        murmur = new Murmur3HashFunction();
    }

    public void hasher(String[] data){
        long[][] longs = new long[M_SIZE][];
        for (int i = 0; i < data.length; i++) {
            longs[i] = murmur.hashMultiple(data[i].getBytes());
        }
    }

    public void insertFile(String path){
        String data = uploadFile(path);
        hasher(data.split(","));
    }

    public String uploadFile(String filePath) {
        String data = "";
        try {
            File file = new File(filePath);
            Scanner myReader = new Scanner(file);
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