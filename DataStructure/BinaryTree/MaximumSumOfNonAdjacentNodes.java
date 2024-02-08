package BinaryTree;
/*
https://www.geeksforgeeks.org/maximum-sum-nodes-binary-tree-no-two-adjacent/

 */
public class MaximumSumOfNonAdjacentNodes {

    static Pair<Integer, Integer> solve(Node root){
        if(root == null)
            return new Pair(0,0);

        Pair<Integer, Integer> leftVal = solve(root.left);
        Pair<Integer, Integer> rightVal = solve(root.right);

        Pair<Integer, Integer> result = new Pair(0,0);
        result.first = root.data + leftVal.second + rightVal.second;
        result.second = Math.max(leftVal.first, leftVal.second) + Math.max(rightVal.first, rightVal.second);
        return result;


    }
    static int getMaxSum(Node root)
    {
        Pair<Integer, Integer> ans = solve(root);
        return Math.max(ans.first, ans.second);
    }

}