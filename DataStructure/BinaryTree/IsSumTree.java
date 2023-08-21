package BinaryTree;

public class IsSumTree {
	
	Pair<Boolean,Integer>  isSumTree(Node root)
	{
		
		//base case
		if(root == null)
			return new Pair<Boolean,Integer>(true,root.data);
		
		Pair<Boolean,Integer> leftAns = isSumTree(root.left);
        Pair<Boolean,Integer> rightAns = isSumTree(root.right);
        
        Boolean isLeftSumTree = leftAns.first;
        Boolean isRightSumTree = rightAns.first;
        
        int leftSum = leftAns.second;
        int rightSum = rightAns.second;
        
        Boolean condition = root.data == leftSum + rightSum;
        
        Pair<Boolean,Integer> ans = new Pair<Boolean,Integer>(true,0);
        
        if(isLeftSumTree && isRightSumTree && condition) {
            ans.first = true;
            ans.second = root.data + leftSum + rightSum ;
        }
        else
        {
            ans.first = false;
        }
        return ans;
		
	}

}
