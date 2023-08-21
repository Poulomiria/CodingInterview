package Recursion;

public class RecursionInStrings {
	public static Boolean checkPalindromeNumber(String str,int left, int right)
	{
		if(left > right)
			return true;
			
		if(str.charAt(left)!= str.charAt(right))
		{
			 return false;	
		}
		return checkPalindromeNumber(str,left++,right--);
	}
	
	public static Boolean checkPalindrome(String str,int left, int right,Boolean palin)
	{
		if(left > right)
			return palin;
			
		if(str.charAt(left)!= str.charAt(right))
		{
			palin = false;	
		}else if(palin && str.charAt(left)== str.charAt(right))
		{
			palin = true;
		}
		left++;
		right--;
		return checkPalindrome(str,left,right,palin);
	}
			
			
	
	public static char[] reverse(char[] arr, int left, int right)
	{
		if(left > right)
			return arr;
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
		left++;
		right--;
		return reverse(arr, left, right);
	}
	
	public static void main(String args[])
	{
		String str = "test";
		char[] rev = reverse(str.toCharArray(),0,str.length()-1);
		System.out.println(String.valueOf(rev));
		System.out.print(checkPalindrome("abccba",0,5,true));
	}

}
