package com.company;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayShifter {
    public static void main(String[] args) {
    int[] ori = new int[] {1,2,3,4,5};
    int d = 1;
    int length =  ori.length;
    int [] shifted = new int[length];
    System.arraycopy(Arrays.copyOfRange(ori , d, length) , 0, shifted, 0, length - d);
    System.arraycopy(Arrays.copyOf(ori , d) , 0, shifted, length - d , d);
        IntStream.of(shifted).forEach(System.out::print);
    }
}
