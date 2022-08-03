package Greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
 * https://leetcode.com/problems/the-maze-ii/
 * There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return the shortest distance for the ball to stop at the destination. If the ball cannot stop at destination, return -1.

The distance is the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included).

You may assume that the borders of the maze are all walls (see examples).
Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
Output: 12
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
The length of the path is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
 */

public class TheMaze2 {
	//DFS approach depth wise traversal using recursion stack
	 public int shortestDistanceDFS(int[][] maze, int[] start, int[] dest) {
	        int[][] distance = new int[maze.length][maze[0].length];
	        for (int[] row: distance)
	            Arrays.fill(row, Integer.MAX_VALUE);
	        distance[start[0]][start[1]] = 0;
	        dfs(maze, start, distance);
	        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
	    }

	    public void dfs(int[][] maze, int[] start, int[][] distance) {
	        int[][] dirs={{0,1}, {0,-1}, {-1,0}, {1,0}};
	        for (int[] dir: dirs) {
	            int x = start[0] + dir[0];
	            int y = start[1] + dir[1];
	            int count = 0;
	            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
	                x += dir[0];
	                y += dir[1];
	                count++;
	            }
	            if (distance[start[0]][start[1]] + count < distance[x - dir[0]][y - dir[1]]) {
	                distance[x - dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
	                dfs(maze, new int[]{x - dir[0],y - dir[1]}, distance);
	            }
	        }
	    }
	//BFS approach using queue
	 public int shortestDistance(int[][] maze, int[] start, int[] dest) {
	        int[][] distance = new int[maze.length][maze[0].length];
	        for (int[] row: distance)
	            Arrays.fill(row, Integer.MAX_VALUE);
	        distance[start[0]][start[1]] = 0;
	         int[][] dirs={{0, 1} ,{0, -1}, {-1, 0}, {1, 0}};
	        Queue < int[] > queue = new LinkedList < > ();
	        queue.add(start);
	        while (!queue.isEmpty()) {
	            int[] s = queue.remove();
	            for (int[] dir: dirs) {
	                int x = s[0] + dir[0];
	                int y = s[1] + dir[1];
	                int count = 0;
	                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
	                    x += dir[0];
	                    y += dir[1];
	                    count++;
	                }
	                if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
	                    distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
	                    queue.add(new int[] {x - dir[0], y - dir[1]});
	                }
	            }
	        }
	        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
	    }
	 //Dijsktra's algorithm 
	  public int shortestDistanceDJ(int[][] maze, int[] start, int[] dest) {
	        int[][] distance = new int[maze.length][maze[0].length];
	        boolean[][] visited = new boolean[maze.length][maze[0].length];
	        for (int[] row: distance)
	            Arrays.fill(row, Integer.MAX_VALUE);
	        distance[start[0]][start[1]] = 0;
	        dijkstra(maze, distance, visited);
	        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
	    }
	    public int[] minDistance(int[][] distance, boolean[][] visited) {
	        int[] min={-1,-1};
	        int min_val = Integer.MAX_VALUE;
	        for (int i = 0; i < distance.length; i++) {
	            for (int j = 0; j < distance[0].length; j++) {
	                if (!visited[i][j] && distance[i][j] < min_val) {
	                    min = new int[] {i, j};
	                    min_val = distance[i][j];
	                }
	            }
	        }
	        return min;
	    }
	    public void dijkstra(int[][] maze, int[][] distance, boolean[][] visited) {
	        int[][] dirs={{0,1},{0,-1},{-1,0},{1,0}};
	        while (true) {
	            int[] s = minDistance(distance, visited);
	            if (s[0] < 0)
	                break;
	            visited[s[0]][s[1]] = true;
	            for (int[] dir: dirs) {
	                int x = s[0] + dir[0];
	                int y = s[1] + dir[1];
	                int count = 0;
	                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
	                    x += dir[0];
	                    y += dir[1];
	                    count++;
	                }
	                if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
	                    distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
	                }
	            }
	        }
	    }

}
