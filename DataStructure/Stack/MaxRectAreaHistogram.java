package Stack;

public class MaxRectAreaHistogram {
    public static long getMaxArea(long hist[], long n) {
        long maxArea = 0;
        int nsl[] = new int[hist.length];
        int nsr[] = new int[hist.length];

        // next smaller right
        Stack<Integer> s = new Stack<>();

        for (int i = hist.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && hist[s.peek()] >= hist[i]){
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = hist.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // next smaller left
        s = new Stack<>();

        for (int i = 0; i <= hist.length - 1; i++) {
            while (!s.isEmpty() && hist[s.peek()] >= hist[i]){
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // Area: width = j-i-1  (nsr[i] - nsl[i] - 1)
        for (int i = 0; i < hist.length; i++) {
            long height = hist[i];
            long width = nsr[i] - nsl[i] - 1;
            long currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }

        return maxArea;
    }
}