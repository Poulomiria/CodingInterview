package Graph;

public class NumberOfProvinces {

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited){
        visited[node] = 1;
        ArrayList<Integer> tempNodes = adj.get(node);
        for(Integer temp : tempNodes)
        {
            if(visited[temp] == 0){
                dfs(temp, adj, visited);
            }
        }
    }


    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        //prepare adjacency list
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < V; i++)
        {
            adjLs.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < V; i++)
        {
            for(int j = 0; j < V; j++)
            {
                if(adj.get(i).get(j) == 1 && i != j)
                {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }

            }
        }
        //visited array
        int[] visited = new int[V];

        int count = 0;
        for(int i = 0; i < V; i++){
            if(visited[i] == 0)
            {
                count++;
                dfs(i, adjLs, visited);
            }
        }
        return count;
    }
}