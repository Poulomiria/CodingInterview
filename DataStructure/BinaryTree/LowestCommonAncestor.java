package BinaryTree;

public class LowestCommonAncestor {

    Node lca(Node root, int n1,int n2)
    {
        if(root == null)
            return root;
        if(root.data == n1 || root.data == n2)
        {
            return root;
        }

        Node leftVal = lca(root.left, n1, n2);
        Node rightVal = lca(root.right, n1, n2);

        if(leftVal != null && rightVal != null)
        {
            return root;
        }else if(leftVal != null && rightVal == null)
        {
            return leftVal;
        }else if(rightVal != null && leftVal == null)
        {
            return rightVal;
        }else{
            return null;
        }

    }
}