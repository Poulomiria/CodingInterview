package Graph;
/*
https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
TC : O(v+e)
SC : O(v)
Using recursion
 */
public class DFSTraversal {

    ArrayList<Integer> DFSUtil(int v, boolean visited[], ArrayList<Integer> result, ArrayList<ArrayList<Integer>> adj){
        //base case
        visited[v] = true;
        result.add(v);

        ArrayList<Integer> nodes = adj.get(v);
        Iterator<Integer> itr = nodes.listIterator();
        while(itr.hasNext())
        {
            int node = itr.next();
            if(!visited[node])
            {

                DFSUtil(node, visited, result, adj);
            }

        }
        return result;

    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList();
        return DFSUtil(0, visited, result, adj);
        //return result;
    }
}

// Java program to print DFS traversal
// from a given graph
import java.io.*;
        import java.util.*;

// This class represents a
// directed graph using adjacency
// list representation
class Graph {
    private int V;

    // Array of lists for
    // Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    @SuppressWarnings("unchecked") Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        // Add w to v's list.
        adj[v].add(w);
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal.
    // It uses recursive DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
    }

    // Driver Code
    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        // Function call
        g.DFS(2);
    }
}
