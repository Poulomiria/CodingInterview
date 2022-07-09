package Easy;

public class Recursionprintn {

	private static void printIntValue(int n)
	{
		if(n == 1)
		{
			System.out.println("Number" + n);
		}else
		{

			System.out.println("Number" + n);
			printIntValue(n-1);		
			
		}	 
	}
	private static int factorial(int n)
	{
		int[] fact = new int[n];
		if(n == 1)
		{
			return 1;
		}else
		{
			fact[n] = n*factorial(n-1);
			return n*factorial(n-1);
			
		}	 
		
	}
	public class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data)
		{
			this.data = data;
		}
	}
	public int height(TreeNode root)
	{
		if(root == null)
			return 0;
		int lh = height(root.left);
		int rh = height(root.right);
		return 1+Math.max(lh,rh);
	}
	public static void main(String args[])
	{
		int n = 100;
		int p = 10;
		 printIntValue(n);
		 int data = factorial(p);
		 System.out.println(data);
		  
		
	}
}
