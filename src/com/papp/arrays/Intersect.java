package com.papp.arrays;

import util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        HashMap<Integer, Integer> firstArrayMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer num = firstArrayMap.get(nums1[i]);
            if(num == null) {
                firstArrayMap.put(nums1[i], 1);
            } else {
                firstArrayMap.put(nums1[i], num + 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            Integer num = firstArrayMap.get(nums2[i]);
            if(num != null) {
                res.add(nums2[i]);
                if(num == 1) firstArrayMap.remove(nums2[i]);
                else firstArrayMap.put(nums2[i], num - 1);
            }
        }

        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
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

        nums1 = new int[]{1,2};
        nums2 = new int[]{1, 1};
        arr = intersect(nums1, nums2);
        Utils.printArray(arr);
    }
}
