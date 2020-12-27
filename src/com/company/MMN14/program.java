package com.company.MMN14;

import java.io.*;
import java.util.Scanner;

public class program {

    public final int K_SIZE = 1000000; // to update this according to C !!!
    public final int M_SIZE = 10000; // to update this according to C !!!
    public int[] hashArr = new int[M_SIZE]; //check if this is the correct size

    public program() {
        for (int i = 0; i < M_SIZE; i++) {
            hashArr[i] = 0;
        }
    }

    public void updloadFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}