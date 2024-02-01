package Stack;
public class Stack{

    //Declare the variables
    private int maxSize;
private int top;
private long[] arr;
//Constructor - one argument
    public Stack(int s) {
        maxSize = s;
        arr = new long[maxSize];
        top = -1;
    }

public void push(long data)
{
    arr[top++] = data;
}
public int pop()
{
    if(top == -1)
        return 0;
    else{
        return arr[top--];
    }
}
public int peek(){
    if(top == -1)
        return 0;
    else{
        return arr[top];
    }
}
public boolean isEmpty(){
    return top == -1? true : false;
}
    public static void main(String[] args) {
        Stack theStack = new Stack(10);
        theStack.push(10);
        theStack.push(20);
        theStack.push(30);
        theStack.push(40);
        theStack.push(50);

        while (!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println("");
    }
}