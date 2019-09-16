package com.company.gs;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderPrimes {
    public static void main(String[] args) {
        int[][] grid = {
                {7, 7, 3, 8, 1},
                {13, 5, 4, 5, 2},
                {9, 2, 12, 3, 9},
                {6, 12, 1, 11, 41}
        };
        var primes = new ArrayList<Integer>();
        sprialMovement(grid, 0, 0, grid.length, grid[0].length, primes);
        //int[] primeArray = primes.toArray(Integer[]::new);
        int[] primeArray = primes.stream().mapToInt(x->x).toArray();
        primes.forEach(System.out::println);
    }

    private static void sprialMovement(int[][] grid, int i, int j, int is, int js, List<Integer> primes) {

        if (i >= is || j >= js)
        {
            return;
        }
        //Top row
        for (int col = j; col < js-1; col++) {
            //System.out.println(grid[i][col]);
            if (checkPrime(grid[i][col])) {
                primes.add(grid[i][col]);
            }
        }

        //Last Column
        for (int row = i; row < is-1; row++) {
            //System.out.println(grid[row][js-1]);
            if (checkPrime(grid[row][js-1])) {
                primes.add(grid[row][js-1]);
            }
        }

        //Last row
        for (int col = js - 1; col > j; col--) {
            //System.out.println(grid[is-1][col]);
            if (checkPrime(grid[is-1][col])) {
                primes.add(grid[is-1][col]);
            }
        }

        //First Column
        for (int row = is - 1; row > i; row--) {
            //System.out.println(grid[row][j]);
            if (checkPrime(grid[row][j])) {
                primes.add(grid[row][j]);
            }
        }

        sprialMovement(grid, i + 1, j + 1, is - 1, js - 1, primes);
    }

    private static boolean checkPrime(int i) {
        if (i == 1) return false;
        if (i <= 3) return true;
        return primeHelper(i, i / 2);
    }

    private static boolean primeHelper(int i, int divisor) {
        if (divisor < 2) return true;
        if (i % divisor == 0) return false;
        return primeHelper(i, divisor - 1);
    }

}
