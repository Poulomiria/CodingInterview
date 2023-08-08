package Recursion;

public class RecursionInSort {
	/*
	
	public void bubbleSort(int[] arr, int size)
	{
		if(size == 0 )
			return;
		for(int i = 0; i < size-1; i++)
		{
			if(arr[i]>arr[i+1])
			{
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = arr[i];
			}
		}
		bubbleSort(arr, size - 1);
	}
	*/
	
	private static void swap(int a, int b)
	{
		int c = 0;
		c = a;
		a = b;
		b = c;
		
	}
	//quick sort partition
	
	public static int partition(int arr[], int s, int e)
	{
		int pivot = arr[s];
    int count = 0;
    //count of elements smaller than pivot element
    for(int i = s + 1; i <= e; i++){
        if(arr[i] <= pivot)
            count++;
    }

    int pivotIdx = s + count;

    //put pivot element at correct position
    int temp = pivot;
    arr[s] = arr[pivotIdx];
    arr[pivotIdx] = temp;

    int sIdx = s;
    int eIdx = e;

    //make smaller elements lie before pivot & larger elements after pivot
    while(sIdx < pivotIdx && eIdx > pivotIdx){

        //move sIdx++ till we find element greater than pivot element in left side
        while(arr[sIdx] <= pivot){
            sIdx++;
        }
        //move eIdx-- till we find smaller elements than pivot in right side
        while(arr[eIdx] > pivot){
            eIdx--;
        }
        //swap the values if found
        if(sIdx < pivotIdx && eIdx > pivotIdx){
            temp = arr[sIdx];
            arr[sIdx] = arr[eIdx];
            arr[eIdx] = temp;

            sIdx++;
            eIdx--;
        }
    }
    return pivotIdx;
}

		
	
	
	public static void quickSort(int[] arr, int start, int end)
	{
		if(start >= end)
			return;
		
		//find the partition
		int p = partition(arr,start, end);
		//sort left part
		quickSort(arr, start, p-1);
		quickSort(arr, p+1, end);
	}
	public static void main(String args[])
	{
		int[] arr = {3,4,2,5,6,9,8,10,44,55,66};
		quickSort(arr, 0, arr.length - 1);
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		
	}

}
