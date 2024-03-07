package BinarySearch;
/*
Author : Poulomi Roy Chowdhury
Link :
https://www.geeksforgeeks.org/problems/find-first-and-last-occurrence-of-x0849/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

Problem Statement :
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Time : O(logn)
Space : O(1)

 */
public class FirstAndLastOccurenceOfAnElement {
    public int[] searchRange(int[] nums, int x) {
        int n = nums.length;
        int left = 0;
        int right = n -1;
        int[] result = new int[]{-1, -1};

        //find first occurence
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] == x)
            {
                result[0] = mid;
                right = mid -1;

            }else if(nums[mid] > x)
            {
                right = mid -1;

            }else{
                left = mid +1;

            }
        }

        //find second occurence
        left = 0;
        right = n -1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] == x)
            {
                result[1] = mid;
                left = mid +1;

            }else if(nums[mid] > x)
            {
                right = mid -1;

            }else{
                left = mid +1;
            }
        }
        return result;
    }


}