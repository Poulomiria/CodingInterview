package Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	static ArrayList<Integer> traversal = new ArrayList();
	
	public static void BFS(int s, Graph g)
	{		
		Queue<Integer> q = new LinkedList();
		boolean[] visited = new boolean[g.vertices];
		visited[s] = true;
		q.offer(s);
		while(!q.isEmpty())
		{
			s = q.poll();
			traversal.add(s);
			Iterator itr = g.adj[s].listIterator();
			while(itr.hasNext())
			{
				int ele = (int) itr.next();
				if(!visited[ele])
				{
					visited[ele] = true;
					q.offer(ele);					
				}
			}
		}
	}
	public static void main(String args[])
	{
		 Graph g = new Graph(4);
		 
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	        BFS(2,g);
	        Iterator itr = traversal.listIterator();
	        while(itr.hasNext())
	        {
             System.out.println(itr.next());
	        }
	        System.out.println("Following is Breadth First Traversal "+
	                           "(starting from vertex 2)");
	 
	        
	}
}
