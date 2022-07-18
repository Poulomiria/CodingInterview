package Algorithms;
/*
 * Given an array Arr[] of N integers. 
 * Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.
 * Input:
N = 5
Arr[] = {1,2,3,-2,5}
Output:
9
Explanation:
Max subarray sum is 9
of elements (1, 2, 3, -2, 5) which 
is a contiguous subarray.
 */


class KadaneAlgo{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n){
        long maxSum = Long.valueOf(arr[0]);
        long currSum = Long.valueOf(arr[0]);
        for(int i = 1; i < n; i++)
        {
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
        // Your code here
        
    }
    
}