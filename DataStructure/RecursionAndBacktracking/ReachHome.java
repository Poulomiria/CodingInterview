package Recursion;

public class ReachHome {

	public static void reachHome(int src, int dest)
	{
		if(src == dest)
		{
			System.out.print("reached");
			return;
		}
		src++;
		reachHome(src, dest);
				
	}
	public static void main(String args[])
	{
		reachHome(1,20);
	}
	
	
}
