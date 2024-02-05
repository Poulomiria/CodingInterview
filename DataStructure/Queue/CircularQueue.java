package Queue;

public class CircularQueue {

    int front;
    int rear;
    int[] arr = new int[100000];
    int size;
    public CircularQueue()
    {
        front = 0;
        rear = 0;
        size = arr.length;
    }
    public void enqueue(int data)
    {
        //full check
        if(rear == (front -1)%(size -1) || (front == 0 && rear == size -1))
        {
            //full
        }

    }

}