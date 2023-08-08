package Recursion;

public class linearSearch {
	
	static Boolean search(int[] arr, int size, int key)
	{
		if(size == 0)
			return false;
		if(arr[size-1] == key)
			return true;
	
			return search(arr, size -1, key);
		
	}
	public static void main(String args[])
	{
	  int[] arr = {3,4,6,5,7,8};
	  int key = 3;
	  int size = arr.length;
	  System.out.println(search(arr,size,key));
	  
	}

}
