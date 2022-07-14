package HashTable;

import java.util.HashSet;

public class AnArrayIsSubsetOrNot {
	
	public static boolean isSubset(int[] arr1, int[] arr2)
	{
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i = 0; i < arr1.length; i++)
		{
			if(!hs.contains(arr1[i]));
			hs.add(arr1[i]);
		}
		for(int j = 0; j < arr2.length; j++)
		{
			if(!hs.contains(arr2[j]))
				return false;
		}
		return true;
	}
	public static void main(String args[]) {
	    
	    int[] arr1 = {9, 4, 7, 1, -2, 6, 5};
	    int[] arr2 = {7, 1, -2};
	    int[] arr3 = {10, 12};

	    System.out.println(isSubset(arr1, arr2));
	    System.out.println(isSubset(arr1, arr3));
	  }

}
