package com.company.gs;

import java.text.DecimalFormat;

public class WeeklyAverageStockPrice {
    private static DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        int[] dailyPrice = {1,1,1,1,1,1,1,7,7,7,7,7,7,7};
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
