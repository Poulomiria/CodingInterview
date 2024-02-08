package BinaryTree;

public class BottomView {

    ArrayList<Integer> result = new ArrayList();
        if(root == null)
            return result;

    //creating queue for level order traversal
    Queue<Pair> q = new LinkedList();

    //creating map to store the horizontal distance and nodes value
    Map<Integer, Integer> map = new TreeMap();


       q.offer(new Pair(root, 1));
       while(!q.isEmpty())
       {
        Pair temp = q.poll();
        Node node = (Node) temp.first;
        int level = (int)temp.second;
        //only one entry should be there for a horizontal distance
           // it will replace the first nodes and keep the last for a HD
        map.put(level, node.data);

        if(node.left != null)
        {
            q.offer(new Pair(node.left, level -1));
        }
        if(node.right != null)
        {
            q.offer(new Pair(node.right, level +1));
        }
    }
    //Iterate through the map

       for(Map.Entry<Integer, Integer> itr : map.entrySet())
    {
        result.add(itr.getValue());
    }
       return result;
}
}