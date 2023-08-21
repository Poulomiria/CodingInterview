package BinaryTree;
/*
 * https://leetcode.com/problems/path-sum/description/
 * 
 */
public class HasPathSum {
	
	public boolean hasPathSum(Node node, int sum)
	{
		//base case
		if(node == null)
			return false;
		//leaf node which has the value left from sum
		if(node.left == null && node.right == null && node.data == sum)
		{
			return true;
		}
		//recursion step
		
		return hasPathSum(node.left, sum - node.data) || hasPathSum(node.right, sum - node.data);
		
	}

}
