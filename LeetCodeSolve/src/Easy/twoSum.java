package Easy;
/*
 * Space O(n)
 * Time O(n)
 */
import java.util.HashMap;
import java.util.Map;

public class twoSum {
	
	public static int[] twoSumResult(int nums[], int target)
	{
		Map<Integer, Integer> map = new HashMap<>();
		int complement = 0;
		for(int i =0; i < nums.length;i++)
		{
			complement = target - nums[i];
			
			if(map.containsKey(complement))
			{
				return new int[] {i, map.get(complement)};
			}
			map.put(nums[i], i);
		}
		return null;
	}
	public static void main(String args[])
	{
		int[] arr  = new int[]{3,4,5,6};
		int target = 7;
		
		int[] temp = twoSumResult(arr, target);
		System.out.println(temp[0]);
		System.out.println(temp[1]);
	}

}
