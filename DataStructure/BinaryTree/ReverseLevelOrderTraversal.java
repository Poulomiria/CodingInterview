package BinaryTree;

import java.util.ArrayList;
import java.util.*;

public class ReverseLevelOrderTraversal {
	
	public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Queue<Node> q = new LinkedList();
        Stack<Node> st = new Stack();
        
        q.add(node);
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            st.push(temp);
            if(temp.right != null)
            {
                q.add(temp.right);
            }
            if(temp.left != null)
            {
                q.add(temp.left);
            }
            
        }
        while(!st.isEmpty())
        {
            Node ele = st.pop();
            ans.add(ele.data);
        }
        return ans;
    }

}
