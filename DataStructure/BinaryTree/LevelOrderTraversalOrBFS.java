package BinaryTree;

import java.util.ArrayList;
import java.util.*;

/*
 * Level order traversal or BFS
 * We can use queue here
 * Time : O(n) Space : O(n), recursive stack for each of the element
 */

public class LevelOrderTraversalOrBFS {
	
	public static ArrayList<Integer> levelOrderTraversal(Node root)
	{
		ArrayList<Integer> ans = new ArrayList();
		
		if(root == null)
			return ans;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node temp = q.poll();
			ans.add(temp.data);
			if(temp.left != null)
			{
				levelOrderTraversal(root.left);
			}
			if(temp.right != null)
			{
				levelOrderTraversal(root.right);
			}
		}
		
		return ans;
	}
	static ArrayList <Integer> levelOrder(Node node)
	{
		ArrayList<Integer> aList = new ArrayList<Integer>();
		Queue<Node> q = new LinkedList<Node>();
		q.offer(node);
		while(!q.isEmpty())
		{
			Node n = q.poll();
			if(n != null)
			{
				aList.add(n.data);
				q.offer(n.left);
				q.offer(n.right);
			}

		}
		return aList;

	}

}
