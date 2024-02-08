package BinaryTree;
/*
https://www.geeksforgeeks.org/problems/k-sum-paths/1

 */
public class KSumPath {

    private void sumKUtil(Node root, int k, ArrayList<Integer> path, Result r)
    {
        if(root == null)
            return;

        path.add(root.data);
        sumKUtil(root.left, k, path, r);
        sumKUtil(root.right, k, path, r);
        int sum = 0;
        int len = path.size();
        for(int i=len -1; i >= 0; i--)
        {
            sum += path.get(i);
            if(sum == k)
            {
                r.count = r.count + 1;
            }

        }
        path.remove(len -1);

    }
    public int sumK(Node root,int k)
    {
        Result r = new Result();
        ArrayList<Integer> path = new ArrayList();
        sumKUtil(root, k, path, r);

        return r.count;

    }
    //Make it more optimize


}