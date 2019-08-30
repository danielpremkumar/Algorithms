package com.company;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 3, 3};
        int[] nums2 = {1, 1, 3, 3};
        System.out.println(findMedianSortedArrays1(nums1, nums2));
    }

    /*
     *  Using ArrayCopy and Sort (Quick Sort)
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        System.arraycopy(nums1,0, merged, 0, nums1.length);
        System.arraycopy(nums2,0, merged, nums1.length, nums2.length);
        Arrays.sort(merged);
        double median = 0.0;
        median = getMedian(merged);
        return median;
    }

    private static double getMedian(int[] merged) {
        double median;
        if (merged.length % 2 == 0) {
            median = ((double)(merged[(merged.length / 2) -1 ] + merged[(merged.length / 2)])) / 2;
        } else {
            median = merged[merged.length / 2 + 1/2];
        }
        return median;
    }

    /*
     * Using Complexity O(log(m + n))
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        double median = ((double)length) / 2;
        if (nums1.length == 0) {
            return getMedian(nums2);
        } else  if (nums2.length == 0) {
            return getMedian(nums1);
        } else {
            int nums1pointer = 0 , nums2pointer = 0, mergedpointer = 0;
            int [] merged = new int[length];
            while(mergedpointer <= median) {
                if (nums1pointer < nums1.length && nums2pointer < nums2.length) {
                    if (nums1[nums1pointer] < nums2[nums2pointer]) {
                        merged[mergedpointer] = nums1[nums1pointer];
                        nums1pointer++;
                        mergedpointer++;
                    } else if (nums1[nums1pointer] > nums2[nums2pointer]) {
                        merged[mergedpointer] = nums2[nums2pointer];
                        nums2pointer++;
                        mergedpointer++;
                    } else {
                        merged[mergedpointer] = nums1[nums1pointer];
                        mergedpointer++;
                        nums1pointer++;
                        merged[mergedpointer] = nums2[nums2pointer];
                        nums2pointer++;
                        mergedpointer++;

                    }
                } else if (nums1pointer >= nums1.length) {
                    merged[mergedpointer] = nums2[nums2pointer];
                    nums2pointer++;
                    mergedpointer++;
                } else if (nums2pointer >= nums2.length) {
                    merged[mergedpointer] = nums1[nums1pointer];
                    nums1pointer++;
                    mergedpointer++;
                }
            }

                    median = getMedian(merged);
        }
        return median;
    }
}
