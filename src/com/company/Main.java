package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        longestCommonSubSequence();
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
