package com.papp.arrays;

import java.util.Arrays;

/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
*/
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 1) return nums[0];
        for (int i = 0; i < nums.length; i+=2) {
            if(i+1 >= nums.length) break;
            if(nums[i] != nums[i+1]) return nums[i];
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1};
        System.out.println(singleNumber(arr));
        arr = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(arr));
    }
}
