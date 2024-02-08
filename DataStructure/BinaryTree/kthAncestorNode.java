package BinaryTree;
/*
https://www.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1
Time : O(n)
Space : O(n)
 */
//This class helps in call by reference as its not present in java
class Result{
    int k;
}
public class kthAncestorNode {

    Node kthAncestorUtil(Node root, int node, Result r)
    {
        //base case
        if(root == null)
            return root;

        if(root.data == node)
        {
            return root;
        }
        Node leftVal = kthAncestorUtil(root.left, node, r);
        Node rightVal = kthAncestorUtil(root.right, node, r);
        if(leftVal != null && rightVal == null)
        {
            r.k--;
            if(r.k <= 0)
            {
                r.k = Integer.MIN_VALUE;
                return root;
            }else{
                return leftVal;
            }
        }
        else if(leftVal == null && rightVal != null)
        {
            r.k--;
            if(r.k <= 0)
            {
                r.k = Integer.MIN_VALUE;
                return root;
            }else{
                return rightVal;
            }
        }else{
            return null;
        }
    }

    public int kthAncestor(Node root, int k, int node)
    {
        Result r = new Result();
        r.k = k;

        Node rNode = kthAncestorUtil(root, node, r);
        if(node == rNode.data || rNode == null )
        {
            return -1;
        }else{
            return rNode.data;
        }

    }
}