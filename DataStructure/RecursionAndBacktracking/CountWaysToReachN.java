package Recursion;
/*
 * https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 */
public class CountWaysToReachN {
	
	public static int countWays(int n)
	{
		//base case
		
		if(n <0)
			return 0;
		if(n==0)
			return 1;
		//induction step or recursive step
		return countWays(n-1) + countWays(n-2);
			
	}
	public static void main(String args[])
	{
		System.out.print(countWays(10));
	}

}
