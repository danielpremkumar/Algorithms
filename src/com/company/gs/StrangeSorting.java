package com.company.gs;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StrangeSorting {
    public static void main(String[] args) {
        int[] actual = new int[]{3, 5, 4, 6, 2, 7, 9, 8, 0, 1};
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        for (int i=0; i<actual.length;i++) {
            integerHashMap.put(actual[i],i);
        }
        String[] bug = new String[]{"990", "332", "32"};
        Stream.of(bug).map(s -> s.chars()
                .map(c -> integerHashMap.get(Integer.valueOf(""+(char)c)))
                .mapToObj(c -> String.valueOf(c))
                .collect(Collectors.joining("")))
                .sorted().map(
                        s -> s.chars()
                                .mapToObj(c-> String.valueOf(actual[Integer.valueOf(""+(char)c)])).collect(Collectors.joining(""))
        )
                .forEach(System.out::println);
    }
}