package BinaryTree;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Left Node Right
 */
public class InorderTraversal {
	
	public static ArrayList<Integer> InorderTraversal(Node root, ArrayList<Integer> ans )
	{
		
		if(root == null)
			return ans;
		
		if(root.left != null)
		{
			InorderTraversal(root.left, ans);
		}
		//System.out.println(root.data);
		ans.add(root.data);
		
		if(root.right != null)
		{
			InorderTraversal(root.right,ans);
		}
		return ans;
	}
	public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        ArrayList<Integer> ans = new ArrayList<Integer>();
 
        // Function call
        System.out.println(
            "Inorder traversal of binary tree is: ");
        ArrayList<Integer> result = InorderTraversal(root,ans);
       // System.out.println(result.size());
        Iterator<Integer> itr = result.iterator();
        while(itr.hasNext())
        {
        	System.out.println(itr.next());
        	
        }
    }

}
