package BinaryTree;

public class LeftView {

    //Recursive
    static void leftViewUtil(ArrayList<Integer> arr, Node root, int level)
    {
        if(root == null)
            return;

        //insert the first element for that level
        if(level == arr.size())
        {
            //store the root value
            arr.add(root.data);
        }
        leftViewUtil(arr, root.left, level+1);

        leftViewUtil(arr, root.right, level+1);

    }
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        if(root == null)
            return aList;
        leftViewUtil(aList, root, 0);
        return aList;
    }
//Iterative way using queue

    ArrayList<Integer> leftView(Node root)
    {

        ArrayList<Integer> aList = new ArrayList<Integer>();
        if(root == null)
            return aList;
        Queue<Node> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0; i < size; i++)
            {
                Node n = q.poll();
                if(i ==0)
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

}