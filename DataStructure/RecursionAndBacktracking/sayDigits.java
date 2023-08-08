package Recursion;

public class sayDigits {
	private static String arr[] = {"zero","one","two","three","four","five","six","seven","eight","nine","ten"};
	
	static void sayDigit(int num)
	{
		//base case
		if(num == 0)
		{
			return;
		}
		int digit = num%10;
		num = num/10;
		sayDigit(num);
		System.out.println(arr[digit]);
	}
	public static void main(String args[])
	{
		sayDigit(678);
	}
}
