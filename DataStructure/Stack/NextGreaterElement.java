package Stack;

public class NextGreaterElement {

    public static long[] nextLargerElement(long[] arr, int n)
    {
        long[] result = new long[n];
        Stack<Long> s = new Stack();
        s.push(-1L);
        for(int i = n-1; i >=0; i--)
        {
            long current = arr[i];
            while(current >= s.peek() && s.peek() != -1)
            {
                s.pop();
            }
            result[i] = s.peek();
            s.push(current);
        }
        return result;
    }
}