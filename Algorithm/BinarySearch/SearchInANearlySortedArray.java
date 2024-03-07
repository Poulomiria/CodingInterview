package BinarySearch;
/*
https://www.geeksforgeeks.org/search-almost-sorted-array/

Given a sorted array arr[] of size N, some elements of array are moved to either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or arr[i-1] i.e. arr[i] can only be swapped with either arr[i+1] or arr[i-1]. The task is to search for an element in this array.

Examples :

Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
Output: 2
Explanation: Output is index of 40 in given array i.e. 2

Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 90
Output: -1
Explanation: -1 is returned to indicate the element is not present
 */
public class SearchInANearlySortedArray {

    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at
            // one of the middle 3 positions
            if (arr[mid] == x)
                return mid;
            if (mid > l && arr[mid - 1] == x)
                return (mid - 1);
            if (mid < r && arr[mid + 1] == x)
                return (mid + 1);

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 2, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 2, r, x);
        }

        // We reach here when element is
        // not present in array
        return -1;
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 3, 2, 10, 4, 40 };
        int n = arr.length;
        int x = 4;
        int result = binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println(
                    "Element is present at index " + result);
    }
}