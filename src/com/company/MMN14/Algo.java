package com.company.MMN14;


import com.sangupta.murmur.Murmur3;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Algo {

    private final int K; // to update this according to C !!!
    private final int m; // to update this according to C !!!
    private int[] hashArr; //check if this is the correct size

    public Algo(int K, int M){
        this.K =K;
        this.m =M;
        this.hashArr = new int[m-1];
    }

    /**
     * This method calculates the index ​​of each value in an array of strings obtained.
     * In case of insertion to the structure, The resulting index will be placed into the hash array.
     * In case of checking the affiliation to the hash array if an index is not marked, this is an element that does not belong to the structure.
     * @param arr An array of strings received from the user for insertion or testing.
     * @param test Test will be made if the test parameter boolean is true.
     */
    public void hasher(String[] arr, boolean test){
        int index;
        boolean ok;
        for (int i = 0; i < arr.length; i++) {
            ok = true;
            for (int j = 1; j <= K; j++) {
                index = Math.abs((int)Murmur3.hash_x86_32(arr[i].getBytes(),arr[i].length(),j))%m;
                if(!test){
                    hashArr[index] = 1;
                }
                else if(hashArr[index] == 0 && test){
                    ok=!ok;
                    break;
                }
            }
            if(!ok){
                System.out.println(arr[i] + " not belongs to the structure");
            }
        }
    }

    /**
     * This method prints the int array.
     */
    public void printHashTable(){
        StringBuffer sb = new StringBuffer();
        sb.append("Hash table indexes:");
        for (int i = 0; i < hashArr.length; i++){
            if(hashArr[i]==1){
                sb.append(i+", ");
            }
        }
        sb.delete(sb.length()-2,sb.length());
        System.out.println(sb.toString());
    }

    /**
     * This method receives a file from the user and converts the file values to an array of strings.
     * @param filePath
     * @param str insert or test string.
     * @return
     */
    public String[] uploadFile(String filePath, String str) {
        String data = "";
        StringBuffer sb = new StringBuffer();
        try {
            File file = new File(filePath);
            Scanner myReader = new Scanner(file);
            sb.append(str);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                sb.append(data);
            }
            myReader.close();
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data.split(",");
    }

}