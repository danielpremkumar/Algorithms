package com.company;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //System.out.println(isAnagram("asd","asd."));
        String a = "asdsa asdsad eret a'as asdsa. sadas,";
        Pattern p = Pattern.compile("[A-Za-z !,?._'@]+");
        int[] b = Arrays.asList(p.split(a)).stream().mapToInt(Integer::parseInt).toArray();
    /*    int[] intArray = Stream.of(b).mapToInt(Integer::parseInt).toArray();

        int maxArea = 0;
        for (Integer curr : intList) {
            for (Integer next : intList) {
                if (curr.equals(next)) continue;
                int base = Math.abs(curr - next);
                int height = Math.min(curr, next);
                int area = base * height;
                if (area > maxArea) maxArea = area;
            }
        }
        intList.stream().forEach(num -> );
        for (String c: b) {
            System.out.println("sadsad"+c);
        }*/

    }
    static boolean isAnagram(String a, String b) {
        java.util.Map<Character, Integer> ma = new java.util.HashMap<>();
        java.util.Map<Character, Integer> mb = new java.util.HashMap<>();
        seg(a, ma);
        seg(b, mb);

        for (java.util.Map.Entry<Character, Integer> c : ma.entrySet()) {
            if(mb.size() != ma.size() || !mb.containsKey(c.getKey()) || mb.get(c.getKey()) != c.getValue()) {
                return false;
            }
        }
        return true;

    }

    private static void seg(String a, java.util.Map<Character, Integer> ma) {
        if (null != a) {
            a.toLowerCase().chars().mapToObj(c -> (char) c)
                    .forEach(c -> {
                        logic(ma, c);
                    });
        }
    }

    private static void logic(java.util.Map<Character, Integer> mb, Character c) {
        if (mb.containsKey(c)) {
            int weight = mb.get(c);
            mb.put(c, weight + 1);
        } else {
            mb.put(c, 1);
        }
    }
    /**
     * This method is used to find the largest continuous character array in sequential order
     * between to String S1 and S2
     */
    private static void longestCommonSubSequence() {
        var s1 = "polymorphic performance test cases";
        var s2 = "talk of the town, great Dog";
        var charSeq =new HashMap<Character, Integer>();
        var longestSeq = "";
        var latestmatchIndex = -1;
        for (char a : s1.toCharArray()) {
            int firstIndex = s2.indexOf(a);

            if (firstIndex ==-1) {
                continue;
            }
            if (charSeq.containsKey(a)) {
                var indexTocheck = firstIndex >= latestmatchIndex ? firstIndex + 1 : latestmatchIndex +1;
                System.out.println("indexTocheck= "+ indexTocheck);
                firstIndex = s2.indexOf(a,indexTocheck);

                if (firstIndex ==-1) {
                    continue;
                }
            }

            if (firstIndex <=  latestmatchIndex) {
                firstIndex = s2.indexOf(a,latestmatchIndex + 1);
            }
            if (firstIndex ==-1) {
                continue;
            }
            System.out.println("new index= "+ firstIndex + " for char: " + a);
            charSeq.put(a,firstIndex);
            latestmatchIndex = firstIndex;
            longestSeq += a;
        }
        System.out.println(longestSeq);
    }
    private static void longestCommonSubSequenceUsingStreams() {
        var s1 = "danielpremkumar";
        var s2 = "ascenaretail.com";

        Stream<Character> c1Stream = IntStream.range(0, s1.toCharArray().length).mapToObj(i -> s1.toCharArray()[i]);
        Stream<Character> c2Stream = IntStream.range(0, s2.toCharArray().length).mapToObj(i -> s2.toCharArray()[i]);
        var s1commons2 = getCommonCharArray(s2, c1Stream);
        var s2commons1 = getCommonCharArray(s1, c2Stream);
        System.out.println(s1commons2);
        System.out.println(s2commons1);
    }
    private static List<Character> getCommonCharArray(String s, Stream<Character> cStream) {
        return cStream
                .filter(a -> s.contains(String.valueOf(a)))
                .collect(Collectors.toList());
    }
}
