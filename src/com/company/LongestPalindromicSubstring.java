package com.company;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        longestPalindrome("Danielpremkumarrajkumar");
    }

    public static String longestPalindrome(String s) {
        int startPointer = 0, endPointer = 0;
        Map<Match, Boolean> map = new HashMap<>();
        for(int i =0; i<s.length();i++) {
            for (int j =s.length()-1; j>=i; j--) {
                map.put(new Match(i, j, s.toLowerCase().charAt(i)),s.toLowerCase().charAt(i) == s.toLowerCase().charAt(j));
            }
        }

        return "";
    }

}
