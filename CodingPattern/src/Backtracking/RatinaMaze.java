package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class RatInMaze {

    static int[][] visited;

    static ArrayList<String> result;

    public static boolean isSafe(int[][] m, int row, int col, int n)
    {
        if(row >=0 && row < n && col >=0 && col < n && visited[row][col] == 0 && m[row][col] == 1)
        {
            return true;
        }else
        {
            return false;
        }

    }
    public static void solvePath(int[][] m, int row, int col,String s, int n)
    {
        if(row == n-1 && col == n-1)
        {
            result.add(s);
            return;
        }
        visited[row][col] = 1;
        //Down
        if(isSafe(m,row+1,col,n))
        {

            solvePath(m,row+1,col,s+"D",n);

        }
        //Up
        if(isSafe(m,row-1,col,n))
        {

            solvePath(m,row-1,col,s+"U",n);

        }
        //Left
        if(isSafe(m,row,col-1,n))
        {

            solvePath(m,row,col-1,s+"L",n);


        }
        //Right
        if(isSafe(m,row,col+1,n))
        {

            solvePath(m,row,col+1,s+"R",n);

        }
        visited[row][col] = 0;

    }

    public static ArrayList<String> findPath(int[][] m, int n)
    {
        visited = new int[n][n];
        result = new ArrayList<>();
        String s = "";
        //Arrays.fill(visited, 0);
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                visited[i][j] = 0;
            }
        }

        if(m[0][0] == 0)
        {

            return result;
        }
        solvePath(m,0,0,s, n);
        return result;
    }

}

