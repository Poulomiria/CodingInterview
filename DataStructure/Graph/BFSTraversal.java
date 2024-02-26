package Graph;
/*
https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
TC : O(v+e)
SC : O(v)
 */
public class BFSTraversal {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> result = new ArrayList();
        Queue<Integer> q = new LinkedList();

        boolean[] visited = new boolean[V];
        visited[0] = true;
        q.offer(0);
        result.add(0);
        while(!q.isEmpty())
        {
            for(int i = 0; i < q.size(); i++)
            {
                int temp = q.poll();
                ArrayList<Integer> nodes = adj.get(temp);
                Iterator<Integer> itr = nodes.listIterator();
                while(itr.hasNext())
                {
                    int node = itr.next();
                    if(!visited[node])
                    {
                        q.offer(node);
                        visited[node] = true;
                        result.add(node);
                    }
                }
            }
        }
        return result;
    }


}

// This class represents a directed graph using adjacency
// list representation
class Graph {

    // No. of vertices
    private int V;

    // Adjacency Lists
    private LinkedList<Integer> adj[];

    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) { adj[v].add(w); }

    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue
                = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {

            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued
            // vertex s.
            // If an adjacent has not been visited,
            // then mark it visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Driver code
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
                "Following is Breadth First Traversal "
                        + "(starting from vertex 2)");

        g.BFS(2);
    }
}
