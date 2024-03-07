package BinarySearch;
/*
Links:
https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1
Problem :
Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Example 1:

Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: 2 occurs 4 times in the
given array

Time : O(logn)
Space : O(1)

 */
public class NumberOfOccurrenceOfAnElement {
/*
To find the count I will find the index of first occurrence and last occurence then minus both of them and plus 1.
I have handled one base case when the element is not present and present in 0th position
 */
    int count(int[] arr, int n, int x) {
        int first = 0;
        int last = 0;
        int left = 0;
        int right = n -1;
        boolean present = false;
        int result = 0;
        //find first
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(arr[mid] == x)
            {
                present = true;
                first = mid;
                right = mid -1;
            }else if(arr[mid] > x)
            {
                right = mid - 1;

            }else{
                left = mid + 1;
            }
        }


        //find second
        left = 0;
        right = n -1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(arr[mid] == x)
            {
                present = true;
                last = mid;
                left = mid +1;
            }else if(arr[mid] > x)
            {
                right = mid - 1;

            }else{
                left = mid + 1;
            }
        }

        if(present)
        {
            result = last - first + 1;
        }
        return result;
    }
}