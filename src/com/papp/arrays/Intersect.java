package com.papp.arrays;

import util.Utils;

import java.util.*;
import java.util.stream.Collectors;

/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/
public class Intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set1, set1Copy, set2;
        if(nums1.length > nums2.length){
            set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            set1Copy = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        } else {
            set1 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
            set1Copy = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
            set2 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        }

        set1.removeAll(set2);
        set1Copy.removeAll(set1);
        int[] res = new int[set1Copy.size()];
        Iterator<Integer> set1CopyIterator = set1Copy.iterator();
        for (int i = 0; i < set1Copy.size(); i++) {
            res[i] = set1CopyIterator.next();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        int[] arr = intersect(nums1, nums2);
        Utils.printArray(arr);

        nums1 = new int[]{4,9,5};
        nums2 = new int[]{9,4,9,8,4};
        arr = intersect(nums1, nums2);
        Utils.printArray(arr);
    }
}
