package BinarySearch;

public class SearchInRotatedSortedArray {
    /*
    The idea is that when rotating the array, there must be one half of the array that is still in sorted order.
    For example, 6 7 1 2 3 4 5, the order is disrupted from the point between 7 and 1. So when doing binary search,
    we can make a judgement that which part is ordered and whether the target is in that range, if yes, continue the search in that half, if not continue in the other half.
    */
    public int binarySearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length -1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[mid] >= nums[left])
            {
                if(target >= nums[left] && target < nums[mid])
                {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(target <= nums[right] && target > nums[mid])
                {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}