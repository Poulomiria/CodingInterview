package BinaryTree;

/*
Both the approach have Time : O(n)
Space : O(n)
 */
public class RightView {

    //Iterative way using queue
    ArrayList<Integer> rightView(Node node) {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        if(node == null)
            return aList;
        Queue<Node> q = new LinkedList();
        q.offer(node);
        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0; i < size; i++)
            {
                Node n = q.poll();
                if(i == size-1)
                {
                    aList.add(n.data);
                }
                if(n.left != null)
                {
                    q.offer(n.left);
                }
                if(n.right != null)
                {
                    q.offer(n.right);
                }
            }
        }
        return aList;
    }
    //Recursive way
    static void rightViewUtil(ArrayList<Integer> arr, Node node, int level)
    {
        if(node == null)
            return;

        if(level == arr.size())
        {
            arr.add(node.data);
        }
        //recursive calls
        rightViewUtil(arr,node.right, level+1);
        rightViewUtil(arr,node.left, level+1);

    }
    ArrayList<Integer> rightView(Node node) {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        if(node == null)
            return aList;
        rightViewUtil(aList, node, 0);
        return aList;


    }
}