package Graph;

public class NumberOfIslands {
        //dfs traversal
        public void dfs(int row, int col, char[][] grid, int endrow, int endcol)
        {
            //base case
            if(row < 0 || row >= endrow || col < 0 || col >= endcol || grid[row][col] == '0')
                return;

            //visited mark as 0 rather than having an extra array
            grid[row][col] = '0';

            dfs(row+1, col, grid, endrow, endcol);
            dfs(row-1, col, grid, endrow, endcol);
            dfs(row, col+1, grid, endrow, endcol);
            dfs(row, col-1, grid, endrow, endcol);

        }
        public int numIslands(char[][] grid) {
            int count = 0;
            int endrow = grid.length ;
            int endcol = grid[0].length ;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++)
                {
                    if(grid[i][j] == '1')
                    {
                        ++count;
                        dfs(i,j, grid, endrow, endcol);
                    }

                }
            }
            return count;
        }
    }
}