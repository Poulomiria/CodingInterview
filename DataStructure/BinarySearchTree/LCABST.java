package BinarySearchTree;
/*
https://www.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1

 */
public class LCABST {

    Node LCA(Node root, int n1, int n2)
    {
        while(root != null)
        {
            if(root.data < n1 && root.data < n2)
                root = root.right;
            else if(root.data > n1 && root.data > 2)
            {
                root = root.left;
            }
        }
        return root;
    }
}