package Stack;
/*
https://www.geeksforgeeks.org/problems/sort-a-stack/1
Time : O(n^2)
Space : O(n) - Recursive stack
 */
public class SortAStackUsingRecursion {

    public Stack<Integer> sort(Stack<Integer> s)
    {
        if(s.isEmpty() == true)
            return s;

        //Remove the top element
        int topElement = s.peek();
        s.pop();
        //recursion for remaining element
        sort(s);
        //Insert the popped element in sorted stack
        InsertTopElement(s, topElement);
        return s;
    }

    static void InsertTopElement(Stack<Integer> s, int top)
    {
        if(s.isEmpty() == true || top > s.peek()){
            s.push(top);
            return;
        }

        //remove the top element
        int topelement = s.peek();
        s.pop();
        InsertTopElement(s, top);
        s.push(topelement);
    }
}