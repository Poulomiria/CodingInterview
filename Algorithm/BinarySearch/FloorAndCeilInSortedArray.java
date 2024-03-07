package BinarySearch;

public class FloorAndCeilInSortedArray {

    //find floor element largest element K in arr[] such that K is smaller
    static int findFloor(long arr[], int n, long x)
    {
        int left = 0;
        int right = n -1;
        long res = -1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;

            if(arr[mid] == x)
            {
                return mid;

            }else if(arr[mid] < x)
            {
                res = mid;
                left = mid + 1;

            }else{
                right = mid -1;
            }
        }
        return (int)res;

    }
    static int findCeil(long arr[], int n, long x)
    {
        int left = 0;
        int right = n -1;
        long res = -1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;

            if(arr[mid] == x)
            {
                return mid;

            }else if(arr[mid] < x)
            {
                left = mid + 1;

            }else{
                res = mid;
                right = mid -1;
            }
        }
        return (int)res;

    }

}