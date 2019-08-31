package com.company;

import java.math.BigInteger;
import java.util.logging.Logger;

public class Recursion {
    static Logger logger  = Logger.getLogger(Recursion.class.getName());
    public static void main(String[] args) {
        logger.info(factorial(5000).toString());
    }

    private static BigInteger factorial(int num) {
        return factHelper(num, BigInteger.ONE);
    }

    /*
     * Tail Recursion (Uses the same Stack frame in every recursion,
     * so stackoverflow does not occur)
     * Last statement in the method directly returns value, so maintaining
     * state of previous stack in not needed.
     * Intermediate value stored and passed to recursive
     * function using variables like accumulator.
     */
    private static BigInteger factHelper(int num, BigInteger accumulator) {
        if (num <= 1) return accumulator;
        else return factHelper(num - 1, BigInteger.valueOf(num).multiply(accumulator));
    }
}
