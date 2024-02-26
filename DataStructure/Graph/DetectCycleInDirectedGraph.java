package Graph;
/*
https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1


 */
public class DetectCycleInDirectedGraph {
        boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack,
                             ArrayList<ArrayList<Integer>> adj) {

            // marking the current node as visited and part of recursion stack.
            if (recStack[i]) return true;

            if (visited[i]) return false;

            visited[i] = true;

            recStack[i] = true;
            List<Integer> children = adj.get(i);

            // calling function recursively for all the vertices
            // adjacent to this vertex.
            for (Integer c : children)
                if (isCyclicUtil(c, visited, recStack, adj)) return true;

            // removing the vertex from recursion stack.
            recStack[i] = false;

            return false;
        }

        // Function to detect cycle in a directed graph.
        public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
            // marking all vertices as not visited and not a part of recursion stack
            boolean[] visited = new boolean[V];
            boolean[] recStack = new boolean[V];

            // calling the recursive helper function to detect cycle in
            // different DFS trees.
            for (int i = 0; i < V; i++)
                if (isCyclicUtil(i, visited, recStack, adj)) return true;

            return false;
        }

    // BFS using topological sort
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] indegree=new int[V];
        int[] result =new int[V];
        //declare a queue for BFS
        Queue<Integer> q=new LinkedList<>();
        //Getting all the indegrees of nodes
        for(int i=0;i<adj.size();i++){
            for(int j:adj.get(i)){
                indegree[j]++;
            }
        }

        //add all the nodes where indegree is 0
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int index=0;
        int count = 0;

        while(!q.isEmpty()){
            int ele=q.poll();
            //add the node in result
            result[index++]=ele;
            count++;

            for(int v : adj.get(ele)){
                //decrease the indegree by 1
                indegree[v]--;
                //if indegre gets 0 then push it to queue
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }
        //if valid topological sort then count will be with number of nodes
        return count == V?false:true;
    }
}
