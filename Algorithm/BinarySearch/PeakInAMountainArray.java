package BinarySearch;
/*
https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
public class PeakInAMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int left =0;
        int right = arr.length -1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(arr[mid] > arr[mid -1] && arr[mid] > arr[mid + 1])
            {
                return mid;
            }else if(arr[mid-1] > arr[mid])
            {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return 0;
    }
}