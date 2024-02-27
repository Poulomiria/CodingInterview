package Graph;

public class RottenOranges {
    /* Using DFS */
    private int endrow;
    private int endcol;

    public void dfs(int i, int j, int[][] grid, int minute) {

        if(i < 0 || i >= endrow || j < 0 || j >= endcol || grid[i][j] == 0) return;

        if(grid[i][j] > 1 &&  grid[i][j] < minute) return;

        grid[i][j] = minute;
        minute++;

        dfs(i+1, j, grid, minute);
        dfs(i-1, j, grid, minute);
        dfs(i, j+1, grid, minute);
        dfs(i, j-1, grid, minute);
    }
    public int orangesRotting(int[][] grid) {

        //time ++ => 1 -> time
        //grid[i][j] < time ==> not change
        //dfs after grid[i][j] == 1 => -1 else time - 2;
        //time == result

        int result = 2; //Integer.MIN_VALUE;
        endrow = grid.length;
        endcol = grid[0].length;

        for(int i = 0; i < endrow; i++) {
            for(int j = 0; j < endcol; j++) {
                if(grid[i][j] == 2) {
                    dfs(i, j, grid, 2);
                }
            }
        }

        for(int i = 0; i < endrow; i++) {
            for(int j = 0; j < endcol; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
                result = Math.max(result, grid[i][j]);
            }
        }
        return result-2;
    }
}
/*Using BFS */
public int orangesRotting(int[][] grid) {
    //queue for BFS traversal
    Queue<Pair<Integer, Integer>> queue = new LinkedList();

    //count the total fresh oranges
    int freshOranges = 0;
    int ROWNUMBER = grid.length, COLNUMBER = grid[0].length;

    for (int r = 0; r < ROWNUMBER; ++r)
        for (int c = 0; c < COLNUMBER; ++c)
            //if rotten orange then push to queue
            if (grid[r][c] == 2)
                queue.offer(new Pair(r, c));
            else if (grid[r][c] == 1)
                //increase the fresh oranges count
                freshOranges++;

    // Mark the round / level, _i.e_ the ticker of timestamp
    queue.offer(new Pair(-1, -1));

    // Step 2). start the rotting process via BFS
    int minutesElapsed = -1;
    int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    while (!queue.isEmpty()) {
        Pair<Integer, Integer> p = queue.poll();
        int row = p.getKey();
        int col = p.getValue();
        if (row == -1) {
            // We finish one round of processing
            minutesElapsed++;
            // to avoid the endless loop
            if (!queue.isEmpty())
                queue.offer(new Pair(-1, -1));
        } else {
            // this is a rotten orange
            // then it would contaminate its neighbors
            for (int[] d : directions) {
                int neighborRow = row + d[0];
                int neighborCol = col + d[1];
                if (neighborRow >= 0 && neighborRow < ROWS &&
                        neighborCol >= 0 && neighborCol < COLS) {
                    if (grid[neighborRow][neighborCol] == 1) {
                        // this orange would be contaminated
                        grid[neighborRow][neighborCol] = 2;
                        freshOranges--;
                        // this orange would then contaminate other oranges
                        queue.offer(new Pair(neighborRow, neighborCol));
                    }
                }
            }
        }
    }

    // return elapsed minutes if no fresh orange left
    return freshOranges == 0 ? minutesElapsed : -1;
}
}