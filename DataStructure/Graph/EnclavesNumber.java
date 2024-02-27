package Graph;

public class EnclavesNumber {
     /*
    We count the total number of land cells in our grid.
    Now we traverse from all land cells on the boundary to find all traversable land cells in the grid.
    The difference of total number of land cells and all land cells traversable from the boundary.

    Complexity

    Time complexity: MxN
    Space complexity: MxN
    */
    //get the number of lands which are connect in boundary
    static int count;
    public void dfs(int[][] grid, int row, int col, int r, int c, int[][] visited)
    {
        //base case
        if(row < 0 || row >= r || col < 0 || col >= c || visited[row][col] == 1 || grid[row][col] != 1)
            return;
        //mark the cell as visited
        visited[row][col] = 1;
        //increase no. of lands
        count++;
        dfs(grid, row+1, col, r ,c, visited);
        dfs(grid, row, col+1, r ,c, visited);
        dfs(grid, row-1, col, r ,c, visited);
        dfs(grid, row, col-1, r ,c, visited);
    }
    public int numEnclaves(int[][] grid) {
        count = 0;
        int totalLand = 0;
        int r = grid.length;
        int c = grid[0].length;

        //visited check
        int[][] visited = new int[r][c];

        for(int i =0; i < r; i++)
        {
            for(int j =0; j < c; j++)
            {
                if(grid[i][j] == 1 )
                {
                    totalLand++;
                    // traversing the grid only if the cell is a land cell && lies on boundary
                    if(i == 0 || i == r -1 || j ==0 || j == c-1)
                    {
                        dfs(grid, i, j, r , c, visited);

                    }

                }

            }
        }
        return totalLand - count;

    }
}