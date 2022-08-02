package Graph;

import java.util.Iterator;



public class DFS {
	
	public void DFSHelper(Graph g, int v, boolean visited[])
	{
		visited[v] = true;
		Iterator<Integer> itr = g.adj[v].listIterator();
		
		while(itr.hasNext())
		{
			int nextnode = itr.next();
			DFSHelper(g, nextnode, visited);
		}
	}

}
