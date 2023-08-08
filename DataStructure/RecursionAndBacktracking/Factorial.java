package Recursion;

public class Factorial {
	
	public static void main(String args[])
	{
		int num = 10;
		System.out.print(fact(num));
		
	}
	static int fact(int num)
	{
		//base case
		if(num == 0)
			return 1;
		else
			return num*fact(num-1);
	}

}
