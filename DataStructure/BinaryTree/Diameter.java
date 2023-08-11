package BinaryTree;

public class Diameter {
	
	Pair<Integer, Integer> diameter(Node node)
	{
		Pair<Integer, Integer> p = new Pair<Integer, Integer>(null, null);
		if(node == null)
		{
			return p;
		}else {
			Pair<Integer, Integer> ldia = diameter(node.left);
			Pair<Integer, Integer> rdia = diameter(node.right);
			
			int op1 = ldia.first;
			int op2 = rdia.first;
			int op3 = ldia.second + rdia.second + 1;
			Pair<Integer, Integer> ans = null;
			ans.first = Math.max(op1,Math.max(op2, op3));
			ans.second = Math.max(ldia.second,  rdia.second) + 1;
			return ans;
			
		}
		
	}

}
