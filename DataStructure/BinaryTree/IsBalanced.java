package BinaryTree;
import BinaryTree.Height;

public class IsBalanced extends Height{
	
	boolean isBalanced(Node node)
	{
		if(node == null)
			return true;
		boolean left = isBalanced(node.left);
		boolean right = isBalanced(node.right);
		boolean diff = Math.abs(heightOfBinaryTree(node.left) - heightOfBinaryTree(node.right)) <= 1;
		
		if(left && right && diff)
		{
			return true;
		}else {
			return false;
		}
	}

}
