package Stack;
/*
https://www.geeksforgeeks.org/problems/the-celebrity-problem/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
Time : O(n)
Space : O(n)
Brute force : compare the matrix values using two loops
Optimal : using stack
 */

public class CelebrityProblem {
    int celebrity(int M[][], int n)
    {

        Stack<Integer> s = new Stack();
        //push all the elements in stack
        for(int i = 0; i < n; i++)
        {
            s.push(i);
        }
        //get two element and check whether they know each other
        while(s.size() > 1)
        {
            int a = s.peek();
            s.pop();
            int b = s.peek();
            s.pop();
            //if a knows b then a is not celebrity
            if(M[a][b] == 1)
            {
                s.push(b);
            }else{
                s.push(a);
            }
        }
        int ans = s.pop();
        int zeroCount = 0;
        int oneCount = 0;
        for(int i = 0; i < n; i++)
        {
            if(M[ans][i] == 0)
                zeroCount++;
            if(M[i][ans] == 1)
                oneCount++;
        }
        if(zeroCount != n || oneCount != n-1)
        {
            return -1;
        }
        return ans;
    }
}