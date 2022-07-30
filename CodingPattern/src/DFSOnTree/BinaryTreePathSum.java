package DFSOnTree;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
	}
	
}

public class BinaryTreePathSum {

	public static boolean pathSum(TreeNode root, int sum)
	{
		if(root == null)
			return false;
		if(root.val == sum && root.left == null && root.right == null)
		{
			return true;
		}
		return pathSum(root.left, sum - root.val) || pathSum(root.right, sum - root.val);
	}
	  public static void main(String[] args) {
		    TreeNode root = new TreeNode(12);
		    root.left = new TreeNode(7);
		    root.right = new TreeNode(1);
		    root.left.left = new TreeNode(9);
		    root.right.left = new TreeNode(10);
		    root.right.right = new TreeNode(5);
		    System.out.println("Tree has path: " + BinaryTreePathSum.pathSum(root, 23));
		    System.out.println("Tree has path: " + BinaryTreePathSum.pathSum(root, 16));
		  }

}
