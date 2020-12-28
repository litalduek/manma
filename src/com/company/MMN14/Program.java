package com.company.MMN14;

import java.io.*;
import java.util.Scanner;

public class Program {

    public final int K_SIZE = 1000000; // to update this according to C !!!
    public final int M_SIZE = 10000; // to update this according to C !!!
    public int[] hashArr = new int[M_SIZE - 1]; //check if this is the correct size

    public void hasher(String[] data){
        for (int i = 0; i < data.length; i++) {
            Murmur3HashFunction.hashMultiple(data[i].getBytes());
        }
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