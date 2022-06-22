package Easy;
import java.util.Arrays;
/*
 * Time : O(n)
 * Space : O(1)
 */
import java.util.HashMap;
import java.util.Map;

public class twoSumWithoutSpace {
	public static int[] twoSumResult(int nums[], int target)
	{
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		int sum = 0;
		while(left < right)
		{
			sum = nums[left] + nums[right];
			if(sum == target)
			{
				return new int[] {left +1 , right+1 };
				
			}else if(sum < target)
			{
				++left;
			}else
			{
				--right;
			}
		}
	
		return null;
	}
	public static void main(String args[])
	{
		int[] arr  = new int[]{3,4,5,6};
		int target = 7;
		
		int[] temp = twoSumResult(arr, target);
		if(temp != null)
		{
			System.out.println(temp[0]);
			System.out.println(temp[1]);
			
		}
		
	}

}
