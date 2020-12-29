package com.company.MMN14;

public class Hasher {

    private final double A = 0.7071067812D;
    private int m,k;

    public Hasher(int msize, int ksize){
        this.m = msize;
        this.k = ksize;
    }

    public int hashMultiplier(int k, int m) {
        double formula = 0.0D;
        formula = Math.floor(m * (k * A % 1.0D));
        return (int)formula;
    }

    public int hashDivider(int k, int m) {
        double formula = 0.0D;
        formula = (k % m);
        return (int)formula;
    }

}
