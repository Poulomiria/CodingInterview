package Recursion;

public class PrintCount {
	
	public static void main(String args[])
	{
		int num = 10;
	    printNumber(num);
		
	}
	public static void printNumber(int n)
	{
		//base case
		if(n == 0)
			return;
		//tail recursion
		//System.out.println(n);
		printNumber(n-1);
		//head recursion
		System.out.println(n);
	}

}
