package Tree;
/*
 * Time : O(N), Space : O(n), Auxiliary stack  
 */
public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val)
	{
		this.val = val;
	}
}
public class LowestCommonAncestors {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//base case
	    if (root == null || root == p || root == q) return root;
	    
	    
	    //Hypotheses
	    TreeNode left = lowestCommonAncestor(root.left, p, q);
	    TreeNode right = lowestCommonAncestor(root.right, p, q);
	  //Induction
	    if(left == null)
	    	return right;
	    else if(right == null)
	    	return left;
	    else
	    {
	    	return root;
	    }
	}

}
