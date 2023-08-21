package BinaryTree;

import java.util.ArrayList;

/*
 * Node Left Right 
 */

public class PreorderTraversal {
	
	public ArrayList<Integer> preorderTraversal(Node root, ArrayList<Integer> ans)
	{
		if(root == null)
		{
			return ans;
		}
		ans.add(root.data);
		if(root.left != null)
		{
			preorderTraversal(root.left, ans);
		}
		if(root.right != null)
		{
			preorderTraversal(root.right, ans);
		}
		return ans;
	}

}
