package Recursion;
import java.util.*;
import java.util.stream.Collectors;
public class PermutationsInString {
	

private void solve(int nums[], List<List<Integer>> ans, int index)
{
    //base case
    if(index >= nums.length)
    {
        ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return;
    }
    for(int i = index; i < nums.length; i++)
    {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
        solve(nums, ans, index+1);
        //Backtrack
         temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;

    }
}


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int index = 0;
        solve(nums,ans,index);
        return ans;
    }


}
