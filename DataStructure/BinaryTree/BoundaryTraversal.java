package BinaryTree;

public class BoundaryTraversal {

    static void traverseLeft(Node node, ArrayList<Integer> arr){
        //base case
        if(node == null || (node.left == null && node.right == null))
            return;

        arr.add(node.data);

        if(node.left != null)
        {
            traverseLeft(node.left, arr);
        }else{
            traverseLeft(node.right, arr);
        }
    }
    static void leafNodes(Node node, ArrayList<Integer> arr)
    {
        if(node == null)
            return;
        if(node.left == null && node.right == null)
        {
            arr.add(node.data);
            return;
        }
        if(node.left != null)
        {
            leafNodes(node.left, arr);
        }
        if(node.right != null)
        {
            leafNodes(node.right, arr);
        }

    }
    static void traverseRightInReverseOrder(Node node, ArrayList<Integer> arr)
    {
        //base condtiion
        if(node == null || (node.left == null && node.right == null))
            return;
        if(node.right != null)
        {
            traverseRightInReverseOrder(node.right, arr);
        }else{
            traverseRightInReverseOrder(node.left, arr);
        }
        arr.add(node.data);

    }
    ArrayList <Integer> boundary(Node node)
    {
        ArrayList<Integer> result = new ArrayList();
        if(node == null)
            return result;
        result.add(node.data);
        //traverse the left part
        traverseLeft(node.left, result);
        //traverse the left leaf nodes
        leafNodes(node.left, result);
        //traverse the right leaf nodes
        leafNodes(node.right, result);
        //traverse the right part in reverse order
        traverseRightInReverseOrder(node.right, result);
        return result;

    }
}