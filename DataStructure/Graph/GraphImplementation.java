package Graph;

//Using adjacency list
public class GraphImplementation<T> {

    private Map<T, List<T>> map = new HashMap();

    public void addVertex(T s)
    {
        map.put(s, new LinkedList<T>);
    }
    public void addEdges(T s, T d, boolean bidirectional)
    {
        if(!map.containsKey(s))
            addVertex(s);
        if(!map.containsKey(d))
            addVertex(d);
        map.get(s).add(d);
        if(bidirectional == true){
            map.get(d).add(s);
        }
    }
    public int getVertexCount()
    {
        return map.keySet().size();
    }
    public void getEdgesCount(boolean bidirection)
    {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        System.out.println("The graph has "
                + count
                + " edges.");
    }
    //This method gives vertex is present or not
    public boolean hasVertex(T s)
    {
        return map.containsKey(s) ? true : false;
    }

    // This method gives whether an edge is present or not.
    public void hasEdge(T s, T d)
    {
        return map.get(s).contains(d)) ? true; false;
    }

}
}