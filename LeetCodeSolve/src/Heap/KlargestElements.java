package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

class KlargestElements {

	public static int[] findKLargest(int[] arr,int k) {
		
		int[] result = new int[k];
		//Min heap
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1,n2) -> (n1-n2));
		for(int nums : arr)
		{
			pq.add(nums);
			if(pq.size() > k)
			{
				pq.poll();
			}
		}
		for(int i = 0; i < k; i++)
		{
			result[i] = pq.poll();
		}
		Arrays.sort(result);
		    return result;
	}
	public static void main(String[] args)
	{
		int[] arr = {4,6,2,7,8,4,5};
		int k = 3;
		int[] result = findKLargest(arr,k);
		for(int i = 0; i < k; i++)
		{
			System.out.println(result[i]);
		}
	}
}
