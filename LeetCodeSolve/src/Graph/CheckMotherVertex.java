package Graph;

import java.util.Arrays;
/*
 * This solution is based on Kosarajuís Strongly Connected Component Algorithm. Initially, we run the DFS on the whole graph in a loop (line 13). The DFS ensures that all the nodes in the graph are visited. If the graph is disconnected, the visited array will still have some vertices which havenít been set to true.
 */

class CheckMotherVertex {
    
    public static int findMotherVertex(Graph g) {
        // visited[] is used for DFS. Initially all are
        // initialized as not visited
        boolean[] visited = new boolean[g.vertices];
        Arrays.fill(visited, false);

        // To store last finished vertex (or mother vertex)
        int lastV = 0;

        // Do a DFS traversal and find the last finished vertex
        for (int i = 0; i < g.vertices; i++) {
            if (visited[i] == false) {
                DFS(g, i, visited);
                lastV = i;
            }
        }

        // If there exist mother vertex (or vetices) in given
        // graph, then lastV must be one (or one of them)

        // Now check if lastV is actually a mother vertex (or graph
        // has a mother vertex). We basically check if every vertex
        // is reachable from lastV or not.

        // Reset all values in visited[] as false and do
        // DFS beginning from lastV to check if all vertices are
        // reachable from it or not.
        Arrays.fill(visited, false);
        DFS(g, lastV, visited);

        for (int i = 0; i < visited.length; i++){
            if(visited[i] == false){
                return -1;
            }
        }

        return lastV;
    }

    // A recursive function to print DFS starting from v
    public static void DFS(Graph g, int node, boolean[] visited) {

        visited[node] = true;
        DoublyLinkedList<Integer>.Node temp = null;
        if (g.adjacencyList[node] !=null)
            temp = g.adjacencyList[node].headNode;

        while(temp != null){
            if(visited[temp.data]){
                temp = temp.nextNode;
            }
            else{
                visited[temp.data] = true;
                DFS(g, temp.data, visited);
                temp = temp.nextNode;
            }
        }
    }
    
    public static void main(String args[]) {
        
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,0);
        g.addEdge(3,1);
        g.printGraph();
        System.out.println("Mother Vertex is: " + findMotherVertex(g));
        
    }
}