//package com.company;
//
//import java.util.LinkedList;
//import java.util.Random;
//
//public class Main {
//
//    public static int searchInLinkedList(LinkedList L1,LinkedList L2,int k,int max,int min){
//
//        int i = 0;
//        int j = 0;
//
//
//        while(L1.get(i)!=null && (int)L1.get(i)<=k){
//
//            j = (int)Math.floor( ((Math.random() * (max - min)) + min));
//            if ((int)L1.get(i)<=(int)L1.get(j) && (int)L1.get(j)<=k){
//                L2.add(L1.get(j));
//                if((int)L2.get(i)==k) {
//                    return i;
//                }
//                i+=1;
//            }
//        }
//
//        if (i==0 || (int)L1.get(i)>k){
//            return 0;
//        }
//
//        return i;
//
//    }
//
//    public static double divisionformula(int k) {
//        double formula = 0.0D;
//        formula = (double)(k % 127);
//        return formula;
//    }
//
//    public static double multipleformula() {
//        double formula = 0.0D;
//        double k = 190.0D;
//        double A = 0.7071067812D;
//        formula = Math.floor(127.0D * (k * A % 1.0D));
//        return formula;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(divisionformula(299));
//
//        LinkedList L1 = new LinkedList();
//        L1.add(0,12);
//        L1.add(1,14);
//        L1.add(2,21);
//        L1.add(3,44);
//        L1.add(4,52);
//
//        LinkedList L2 = new LinkedList();
//        L2.add(0,12);
//
//        int i = searchInLinkedList(L1,L2,44,L1.size(),0);
//
//    }
//
//}
