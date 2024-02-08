package BinaryTree;
/*
https://www.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1
Call by reference not possible in java
 */
public class LongestPathRootToLeaf {
    class Res
    {
        int maxSum = Integer.MIN_VALUE; // create a variable to store the maximum sum, initialize it to the smallest possible value
        int maxLen = 0; // create a variable to store the maximum length, initialize it to 0
    }

    public int sumOfLongRootToLeafPath(Node root)
    {
        Res r = new Res(); // create an object of the Res class to store the result
        Res s = new Res(); // create an object of the Res class to store intermediate result
        if(root == null)
            return 0; // if root is null, return 0 as there are no nodes

        sumOfLongRootToLeafPathUtil(root, 0, 0, s, r); // call the helper function to calculate the maximum sum of the long root to leaf path
        return r.maxSum; // return the maximum sum
    }

    public void sumOfLongRootToLeafPathUtil(Node root, int sum, int len, Res s, Res r)
    {
        if(root == null) // if current node is null, check if current length is greater than the maximum length obtained so far
        {
            if (s.maxLen < len)
            {
                s.maxLen = len; // update the maximum length
                r.maxSum = sum; // update the maximum sum
            }
            else if (s.maxLen == len && r.maxSum < sum)
                r.maxSum = sum; // update the maximum sum if current length is equal to the maximum length obtained so far and current sum is greater

            return; // return as we have reached the leaf node
        }

        sumOfLongRootToLeafPathUtil(root.left, sum + root.data, len + 1, s, r); // recursively call the function for the left child with updated sum and length
        sumOfLongRootToLeafPathUtil(root.right, sum + root.data, len + 1,s, r); // recursively call the function for the right child with updated sum and length
    }


}