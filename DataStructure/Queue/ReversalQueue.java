package Queue;
/*
Difference between offer and add in queue
offer gives false if queue is full but add throws IllegalStateException if queue is full
Exception handling better to use offer
 */
public class ReversalQueue {

    //Stack overflow could happen better to use stack
    public Queue<Integer> rev(Queue<Integer> q){

        if(!q.isEmpty())
        {

            int ele = q.poll();
            q = rev(q);
            q.offer(ele);

        }
        return q;
    }

    //Using stack
    public Queue<Integer> rev(Queue<Integer> q){
        Stack<Integer> s = new Stack();

        while(!q.isEmpty())
        {
            s.push(q.poll());
        }
        while(!s.isEmpty())
        {
            q.offer(s.pop());
        }
        return q;
    }


}