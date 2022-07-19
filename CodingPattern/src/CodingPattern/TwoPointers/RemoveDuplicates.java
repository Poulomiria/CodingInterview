package CodingPattern.TwoPointers;


class RemoveDuplicates {

	  public static int remove(int[] arr) {
	    int nextNonDuplicate = 1; // index of the next non-duplicate element
	    for (int i = 0; i < arr.length; i++) {
	      if (arr[nextNonDuplicate - 1] != arr[i]) {
	        arr[nextNonDuplicate] = arr[i];
	        nextNonDuplicate++;
	      }
	    }

	    return nextNonDuplicate;
	  }
	  /*
	   * Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.
	   */
	  public static int remove(int[] arr, int key) {
		    int nextElement = 0; // index of the next element which is not 'key'
		    for (int i = 0; i < arr.length; i++) {
		      if (arr[i] != key) {
		        arr[nextElement] = arr[i];
		        nextElement++;
		      }
		    }

		    return nextElement;
		  }

	  public static void main(String[] args) {
	    int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
	    System.out.println(RemoveDuplicates.remove(arr));

	    arr = new int[] { 2, 2, 2, 11 };
	    System.out.println(RemoveDuplicates.remove(arr));
	  }
	}
