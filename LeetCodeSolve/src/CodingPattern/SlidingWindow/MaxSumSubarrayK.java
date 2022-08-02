package CodingPattern.SlidingWindow;

public class MaxSumSubarrayK {
	public static int MaxSum(int[] arr, int k)
	{
	 int winSum = 0;
	 int maxSum = 0;
	 int winStart = 0;
	 for(int winEnd = 0; winEnd < arr.length; winEnd++)
	 {
	  winSum +=  arr[winEnd];
	  if(winEnd >= k)
	  {
	   
	   winSum = winSum - arr[winStart];
	   winStart++;
	  }
	  maxSum = Math.max(maxSum, winSum);
	 }
	 return maxSum;
	}
	public static void main(String args[])
	{
		int[] arr = {2, 1, 5, 1, 3, 2};
		int k = 3;
		System.out.println(MaxSum(arr,k));
	}

}
