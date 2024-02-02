package Queue;

public class Queue {

    int front, rear;
    int arr[] = new int[100005];

    MyQueue()
    {
        front=0;
        rear=0;
    }

    //Function to push an element x in a queue.
    void push(int x)
    {
        // Your code here
        arr[rear] = x;
        rear++;
    }

    //Function to pop an element from queue and return that element.
    int pop()
    {
        if(rear == 0 || front == rear)return -1;
        int val = arr[front];
        front++;
        return val;
    }
}