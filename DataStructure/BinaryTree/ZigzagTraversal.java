package BinaryTree;

public class ZigzagTraversal {
    ArrayList<Integer> zigZagTraversal(Node root)
    {
        ArrayList<Integer> aList = new ArrayList();
        if(root == null)
            return aList;
        Queue<Node> q = new LinkedList();
        q.offer(root);
        boolean leftToRight = true;
        while(!q.isEmpty())
        {
            //size will give the number of elements in that level
            int size = q.size();
            int[] arr = new int[size];
            //level wise process
            for(int i = 0; i < size; i++)
            {
                Node n = q.poll();
                int index = leftToRight? i : size - i -1;
                arr[index] = n.data;
                if(n.left != null)
                {
                    q.offer(n.left);
                }
                if(n.right != null)
                {
                    q.offer(n.right);
                }
            }
            //change the direction
            leftToRight = !leftToRight;
            for(int i : arr)
            {
                aList.add(i);
            }
        }
        return aList;
    }
}