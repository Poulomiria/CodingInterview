package Queue;

public class Queue {

    int front, rear;
    int arr[] = new int[100005];
    int size;

    MyQueue()
    {
        front=0;
        rear=0;
        size = arr.length;
    }

    //Function to push an element x in a queue.
    void push(int x)
    {
        // Your code here
        if(rear == size)
        {
            System.out.println("Queue is full");
        }
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
    boolean isEmpty(){
        if(front == rear)
            return true;
        else
            return false;

    }
}