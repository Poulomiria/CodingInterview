package BinaryTree;

public class BurningTree {

    public Node findTargetNode(Node node , int x){
        if(node==null){
            return null;
        }
        if(node.data == x){
            return node;
        }
        Node left = findTargetNode(node.left, x);
        Node right = findTargetNode(node.right, x);
        if(left==null && right==null){
            return null;
        }
        else if(left==null){
            return right;
        }
        else{
            return left;
        }
    }
    public int minTime(Node root, int target)
    {
        int time=0;
        Node targetNode = findTargetNode(root,target);
        HashMap<Integer,Node> hm = new HashMap<>();
        //Level order traversal and child to parent mapping
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        while(!que.isEmpty()){
            Node temp = que.poll();
            if(temp.left!=null){
                hm.put(temp.left.data,temp);
                que.add(temp.left);
            }
            if(temp.right!=null){
                hm.put(temp.right.data,temp);
                que.add(temp.right);
            }
        }

        //Min time calculation

        Queue<Node> queue = new LinkedList<Node>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(targetNode);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node tempNode = queue.poll();
                if(tempNode.left!=null && !visited.contains(tempNode.left.data)){
                    queue.add(tempNode.left);
                }
                if(tempNode.right!=null && !visited.contains(tempNode.right.data)){
                    queue.add(tempNode.right);
                }
                if(hm.containsKey(tempNode.data) && !visited.contains(hm.get(tempNode.data).data)){
                    queue.add(hm.get(tempNode.data));
                }
                visited.add(tempNode.data);
            }
            time++;
        }
        return time-1;
    }
}