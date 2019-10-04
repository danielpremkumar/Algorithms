package com.company.gs;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WeeklyAverageStockPrice {
    private static DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        int[] dailyPrice = {1,1,1,1,1,1,1,7,7,7,7,7,7,7};
        Map<Boolean, List<Integer>> result = Arrays.stream(dailyPrice).boxed()
                .collect(Collectors.partitioningBy(e-> e>3));
        Map<Integer, List<String>> te = IntStream.of(dailyPrice).boxed()
                .collect(Collectors.groupingBy(Integer::valueOf, Collectors.mapping(String::valueOf, Collectors.toUnmodifiableList())));

        Map<Integer, Long> te1 = IntStream.of(dailyPrice).boxed()
                .collect(Collectors.groupingBy(Integer::valueOf, Collectors.counting()));

        Map<Integer, Integer> te2 = IntStream.of(dailyPrice).boxed()
                .collect(Collectors.groupingBy(Integer::valueOf, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        String[] weeklyPrices = new String[dailyPrice.length -6];

        for (int i=0; i<weeklyPrices.length;i++) {
            weeklyPrices[i] = averageWeeklyPrice(dailyPrice, i + 6);
        }
        for (String x : weeklyPrices) {
            System.out.println(x);
        }
    }

    private static String averageWeeklyPrice(int[] dailyPrice, int i) {
        float average = 0.0f;
        for (int index = i; index>= i-6;index--) {
            average += dailyPrice[index];
        }
        average/=7;
        return df.format(average);
    }

}
