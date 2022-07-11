package Tree;


class MinValInTree {

    public static int findMin(Node root) {
        
        if (root == null)
            return -1;
        // In Binary Search Tree, all values in current node's left subtree are smaller 
        // than the current node's value.
        // So keep traversing (in order) towards left till you reach leaf node, and then return leaf node's value
        while (root.getLeftChild() != null) {
            root = root.getLeftChild();
        }
        return root.getData();
    }

    public static void main(String args[]) {

        BinarySearchTree bsT = new BinarySearchTree();
        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        bsT.add(12);
        bsT.add(10);
        bsT.add(14);

        System.out.println(findMin(bsT.getRoot()));

    }
}