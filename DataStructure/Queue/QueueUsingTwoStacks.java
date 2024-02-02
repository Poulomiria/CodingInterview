package Queue;

public class QueueUsingTwoStacks {
        Stack<Integer> input = new Stack<Integer>();
        Stack<Integer> output = new Stack<Integer>();

        /*The method pop which return the element poped out of the stack*/
        int dequeue()
        {
            if(input.isEmpty())
            {
                return -1;
            }else{
                int ele = input.pop();
                return ele;
            }
        }

        /* The method push to push element into the stack */
        void enqueue(int x)
        {
            while(!input.isEmpty())
            {
                output.add(input.pop());

            }
            input.push(x);
            while(!output.isEmpty())
            {
                input.add(output.pop());
            }
        }
    }