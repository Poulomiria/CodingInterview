package BinaryTree;

public class RightView {

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
}