package Graph;

import java.util.ArrayList;

public class Graph {
	Integer vertices;
	ArrayList<Integer> adj[];
	Graph(int v)
	{
		vertices = v;
	     adj = new ArrayList[vertices];
	        for (int i=0; i<v; ++i)
	            adj[i] = new ArrayList<Integer>();
		
	}
	void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
}
