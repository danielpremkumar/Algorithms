package com.company;

import java.sql.ResultSet;
import java.util.*;

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

    int[] q = {12323, 3};
        Arrays.sort(q);
        String multiLine = """
<div>
    <h1>Daniel</h1>
</div>
""";
        LinkedList<Integer> cc = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        cc.hashCode();
        System.out.println(multiLine);
        int testing = 6;
        String result = switch(testing) {
            case 2,4,6,8  -> "even";
            default -> "odd";
        };
        PaymentGroup creditCard = PaymentGroup.CREDIT_CARD;
        System.out.println(switch (creditCard) {
            case GIFT_CARD -> "Gift Card";
            case CREDIT_CARD -> "Credit Card";
            default -> "Default";
        });
        System.out.println(result);
        return result;
        //map.entrySet().stream().filter(s-> s.getValue()).
       // return "";
    }

}
