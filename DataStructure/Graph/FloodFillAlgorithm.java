package Graph;

public class FloodFillAlgorithm {
        //dfs
        public void dfs(int[][] image, int row, int col, int color, int[][] result, int iniColor)
        {
            int endrow = image.length;
            int endcol = image[0].length;
            //base case
            if(row < 0 || row >= endrow || col < 0 || col >= endcol || image[row][col] != iniColor || result[row][col] == color )
                return;
            // make the cell with new color
            result[row][col] = color;
            //recursive calls

            dfs(image, row+1, col, color, result, iniColor);
            dfs(image, row-1, col, color, result, iniColor);
            dfs(image, row, col+1, color, result, iniColor);
            dfs(image, row, col-1, color, result, iniColor);


        }
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {

            int iniColor = image[sr][sc];
            int result[][] = image;
            dfs(image, sr, sc, color, result, iniColor);
            return result;
        }
    }
