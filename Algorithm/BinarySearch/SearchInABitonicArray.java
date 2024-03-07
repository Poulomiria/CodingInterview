package BinarySearch;

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class SearchInABitonicArray {
    static int binarySearch(int[] arr, int left,int right, int target)
    {
        int mid = 0;
        while(left <= right)
        {
            mid = left + (right - left)/2;
            if(arr[mid] == target)
            {
                return mid;
            }else if(arr[mid] > target)
            {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
    static int binarySearchReverse(int[] arr, int left, int right, int target)
    {
        int mid = 0;
        while(left <= right)
        {
            mid = left + (right - left)/2;
            if(arr[mid] == target)
            {
                return mid;
            }else if(arr[mid] > target)
            {
                left = mid - 1;
            }else{
                right = mid + 1;
            }
        }
        return -1;
    }
    static int findBitonicPoint(int[] arr, int n) {
        int left = 0;
        int right = n -1;

        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(mid > 0 && mid < n-1 && arr[mid] > arr[mid -1] && arr[mid] > arr[mid + 1]){
                return arr[mid];
            }else if(mid > 0 && arr[mid - 1] > arr[mid])
            {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return arr[n-1];
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();

        int bp = findBitonicPoint(arr, n);
        int res = binarySearch(arr, 0,bp -1, target);
        if(res != -1)
        {
            res = binarySearchReverse(arr, bp, n-1, target);
        }
    }

}

