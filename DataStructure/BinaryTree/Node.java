package BinaryTree;
import java.util.*;

public class Node {
	
	public int data;
	public Node left;
	public Node right;
	
	public Node(int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public static Node buildTree(Node root)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data");
		int data = sc.nextInt();
		root = new Node(data);
		if(data == -1)
			return null;
		System.out.println("Enter left data for root" + data);
		root.left = buildTree(root.left);
		System.out.println("Enter right data for root" + data);
		root.right = buildTree(root.right);
		return root;
		
	}
	public static void printTree(Node root)
	{
		if(root != null)
		{
			System.out.println(root.data);
			printTree(root.left);
			printTree(root.right);
		}
		
	}
	public static void main(String args[])
	{
		Node root = null;
		
		buildTree(root);
		
		printTree(root);
	}

}
