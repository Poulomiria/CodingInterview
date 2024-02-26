package Graph;

/*
https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

 */
public class DetectCycleInUndirectedGraph {
    // Time Complexity: O(V + E)
// Space Complexity: O(V)
    public boolean dfs(int src , int parent ,  ArrayList<ArrayList<Integer>> adj ,boolean []vis)
    {
        vis[src] = true;
        for(int i : adj.get(src))
        {
            if(i == parent) continue;
            if(vis[i] == true) return true;
            else{
                if(dfs(i,src,adj,vis)) return true;
            }
        }
        return false;
    }
    //Exact same logic like dfs -> src and parent
    //push node with parent into stack and do for nbr
    // Time Complexity: O(V + E)
// Space Complexity: O(V)
    public boolean bfs(int src ,int parent ,  ArrayList<ArrayList<Integer>> adj ,boolean []vis)
    {

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src,parent));
        while(q.size()>0)
        {
            Pair top = q.remove();
            int node = top.node;
            int p = top.parent;
            vis[node] = true;
            for(int i : adj.get(node))
            {
                if(vis[i] == false)
                {
                    q.add(new Pair(i,node));
                }
                else if(i!=p)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean []vis = new boolean[V];
        for(int i = 0 ; i < V ; i++)
        {
            // if(!vis[i] && dfs(i,-1,adj,vis)) return true;
            if(!vis[i] && bfs(i,-1,adj,vis)) return true;
        }
        return false;
    }
}

//Another solution using hashmap but needs to be optimal

class Solution {

    boolean bfs(int v,int par, ArrayList<ArrayList<Integer>> adj, boolean[] visited)
    {
        HashMap<Integer, Integer> childParentMap = new HashMap();
        Queue<Integer> q = new LinkedList();
        q.offer(v);
        visited[v] = true;
        childParentMap.put(v, par);

        while(!q.isEmpty())
        {
            while(q.size() > 0)
            {
                int parent = q.poll();
                //loop through children

                visited[parent] = true;
                for(int node : adj.get(parent))
                {
                    if(!visited[node])
                    {
                        q.offer(node);

                        childParentMap.put(node, parent);
                    }else if(childParentMap.get(parent) != node)
                    {
                        return true;
                    }
                }

            }
        }

        return false;


    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean result = false;

        //to store the parent

        //BFS Traversal
        for(int i = 0; i < V; i++)
        {
            if(!visited[i])
            {
                if(bfs(i, -1, adj, visited)) return true;
            }
        }

        return false;
    }
}

