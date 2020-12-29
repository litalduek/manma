package com.company.MMN14;

public class Hasher {

    private final double A = 0.7071067812D;
    private int m;

    public Hasher(int msize){
        this.m = msize;
    }

    public int hashMultiplier(int k) {
        double formula = 0.0D;
        formula = Math.floor(m * (k * A % 1.0D));
        return (int)formula;
    }

    public int hashDivider(int k) {
        double formula = 0.0D;
        formula = (k % m);
        return (int)formula;
    }

}
