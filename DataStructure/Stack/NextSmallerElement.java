package Stack;
/*
Brute force - using two loops Time : O(n^2)
Optimal - using stack Time : O(n)
*/
public class NextSmallerElement {

    public static int[] nextSmaller(int arr[], int n)
    {
        int[] result = new int[n];
        Stack<Integer> s = new Stack();
        s.push(-1);
        for(int i = n-1; i >=0; i--)
        {
            int current = arr[i];
            while(current <= s.peek())
            {
                s.pop();
            }
            result[i] = s.peek();
            s.push(current);
        }
        return result;
    }
    public static int[] prevSmaller(int arr[], int n)
    {
        int[] result = new int[n];
        Stack<Integer> s = new Stack();
        s.push(-1);
        for(int i = 0; i <n; i++)
        {
            int current = arr[i];
            while(current <= s.peek())
            {
                s.pop();
            }
            result[i] = s.peek();
            s.push(current);
        }
        return result;
    }
}