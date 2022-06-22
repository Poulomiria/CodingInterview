package Easy;
/* https://leetcode.com/problems/3sum/submissions/
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

 * Time : Time Complexity: O(n^2)
 * Space : O(n) 
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class threeSum {
	

	public static List<List<Integer>> threeSumResult(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        return res;
    }
    static void twoSum(int[] nums, int i, List<List<Integer>> res) {
        var seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1])
                    ++j;
            }
            seen.add(nums[j]);
        }
    }
    public static void main(String args[])
	{
		int[] arr  = new int[] {-1,0,1,2,-1,-4};
		
		
		List<List<Integer>> temp = threeSumResult(arr);
		
		if(temp != null)
		{
			System.out.println(temp.get(0));
			System.out.println(temp.get(1));
			System.out.println(temp.get(1));
			
		}
}
}
