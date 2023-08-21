package BinaryTree;

public class Height {
	
	public int heightOfBinaryTree(Node node)
	{
		if(node == null)
		{
			return 0;
		}else {
			int l = heightOfBinaryTree(node.left);
			int r = heightOfBinaryTree(node.right);
			return Math.max(l, r) + 1;
		}
	}

}
