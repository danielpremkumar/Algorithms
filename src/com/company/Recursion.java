package com.company;

import java.math.BigInteger;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(factorial(5000));
    }

    private static BigInteger factorial(int num) {
        return factHelper(num, BigInteger.ONE);
    }

    /*
     * Tail Recursion (Uses the same Stack frame in every recursion,
     * so stackoverflow does not occur)
     * Last statement in the method directly returns value, so maintaining
     * state of previous stack in not needed
     */
    private static BigInteger factHelper(int num, BigInteger accumulator) {
        if (num <= 1) return accumulator;
        else return factHelper(num - 1, BigInteger.valueOf(num).multiply(accumulator));
    }
}
