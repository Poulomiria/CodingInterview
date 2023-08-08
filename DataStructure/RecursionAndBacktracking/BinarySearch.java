package Recursion;

public class BinarySearch {
	
	static Boolean binarySearch(int arr[], int start, int end, int key )
	{
		//base case
		if(start > end)
			return false;
		
		int mid = start + (end-start)/2;
		if(arr[mid] == key)
			return true;
		if(arr[mid] < key)
			return binarySearch(arr, start, mid -1, key);
		else
			return binarySearch(arr, mid + 1, end, key);
	}
	public static void main(String[] args) {
        int[] arr = {2 ,3 , 4 ,10 , 12, 122};
        int key = 3;

        Boolean ans = binarySearch(arr , 0 , 5  , key);

        if(ans)
            System.out.println("Not Found");

        else
            System.out.println("Element present at index " + ans);
    }

}
