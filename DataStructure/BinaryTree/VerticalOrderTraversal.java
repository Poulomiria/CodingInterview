package BinaryTree;

public class VerticalOrderTraversal {

    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        ArrayList <Integer> res = new ArrayList <Integer>(0);

        //creating empty queue for level order traversal.
        Queue<Pair>q=new LinkedList<Pair>();

        //creating a map to store nodes at a particular horizontal distance.
        Map<Integer,ArrayList<Integer>>mp=new TreeMap<>();

        q.add(new Pair(root, 0));
        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            Node temp_root = (Node)temp.node;
            int hd = (int)temp.hd;
            if (mp.containsKey(hd))
            {
                ArrayList<Integer>al=mp.get(hd);
                al.add(temp_root.data);
                mp.put(hd,al);
            }
            else
            {
                ArrayList<Integer>al=new ArrayList<>();
                al.add(temp_root.data);
                mp.put(hd,al);
            }

            //if left child of temp_root exists, pushing it in
            //the queue with the horizontal distance.
            if(temp_root.left!=null)
                q.add(new Pair(temp_root.left, hd-1));

            //if right child of temp_root exists, pushing it in
            //the queue with the horizontal distance.
            if(temp_root.right!=null)
                q.add(new Pair(temp_root.right, hd+1));

        }

        //traversing the map and storing the nodes in list
        //at every horizontal distance.
        for(Map.Entry<Integer,ArrayList<Integer>>m:mp.entrySet())
        {
            ArrayList<Integer>al=m.getValue();
            for(int i=0;i<al.size();i++)
                res.add(al.get(i));
        }
        //returning the output list.
        return res;
    }
}