package BinarySearch;

class BinarySearch {
	int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
  
            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;
  
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
  
            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }
  
        // We reach here when element is not present
        // in array
        return -1;
    }
  

	  public static int search(int[] arr, int key) {
	    int start = 0, end = arr.length - 1;
	    boolean isAscending = arr[start] < arr[end];
	    while (start <= end) {
	      // calculate the middle of the current range
	      int mid = start + (end - start) / 2;

	      if (key == arr[mid])
	        return mid;

	      if (isAscending) { // ascending order
	        if (key < arr[mid]) {
	          end = mid - 1; // the 'key' can be in the first half
	        } else { // key > arr[mid]
	          start = mid + 1; // the 'key' can be in the second half
	        }
	      } else { // descending order        
	        if (key > arr[mid]) {
	          end = mid - 1; // the 'key' can be in the first half
	        } else { // key < arr[mid]
	          start = mid + 1; // the 'key' can be in the second half
	        }
	      }
	    }
	    return -1; // element not found
	  }

	  public static void main(String[] args) {
	    System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
	    System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
	    System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
	    System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
	  }
	}