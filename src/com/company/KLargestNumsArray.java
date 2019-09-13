package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KLargestNumsArray {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //int testcases = scanner.nextInt();
        /*while (testcases > 0) {
            executeTestCase(scanner);
            testcases--;
        }*/
        int[] a = new int[]{2, 5, 6, 1, 55, 4};
        System.out.println(Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).limit(3).map(String::valueOf).collect(Collectors.joining(" ")));
        sort(a, 3);
    }

    private static void executeTestCase(Scanner scanner) {
        int lenght = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            array[i] = scanner.nextInt();
        }

        sort(array, k);
    }

    private static void sort(int[] array, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                    //printArray(array);
                    continue;
                }
                //printArray(array);
            }
            printArray(array);
        }
        printArray(array);
    }

    private static void printArray(int[] array) {
        var d = Arrays.stream(array).mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(d);
    }
}
