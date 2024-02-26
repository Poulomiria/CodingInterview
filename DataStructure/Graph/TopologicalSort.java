package Graph;
/*
https://www.geeksforgeeks.org/problems/topological-sort/1
Kahn's algo
using BFS traversal

 */
public class TopologicalSort {

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

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

        while(!q.isEmpty()){
            int ele=q.poll();
            //add the node in result
            result[index++]=ele;

            for(int v : adj.get(ele)){
                //decrease the indegree by 1
                indegree[v]--;
                //if indegre gets 0 then push it to queue
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }
        return result;
    }
}