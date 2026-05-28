package com.mk.java.graph;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };

        int sr = 1, sc = 1, newColor = 2;

        System.out.println("Original Grid:");
         printGrid(grid);

        floodFill(grid, sr, sc, newColor);

        System.out.println("\nAfter Flood Fill:");
          printGrid(grid);

        int[][] grid1 = {
                {1, 1, 1, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        System.out.println("Original Grid:");
        printGrid(grid1);
          floodFillDfs(grid1, sr, sc, newColor);

        System.out.println("\nAfter Flood Fill DFS:");
        printGrid(grid1);

    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }


    private static int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        int oldColor = grid[sr][sc];

        if (sr < 0 || sr > m || sc < 0 || sc > n || oldColor == newColor)
            return grid;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{sr, sc});

        int[] dr = {0,-1, 0, 1};
        int[] dc = {1, 0,-1, 0};

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int r = data[0];
            int c = data[1];

            grid[r][c] = newColor;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr <= m && nc >= 0 && nc <= n && grid[nr][nc] == oldColor) {
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return grid;
    }

    //{1, 1, 1, 1, 1},
//    {1, 1, 0, 0, 0},
//    {1, 0, 1, 1, 1},   1,1
//    {1, 0, 0, 0, 0},
//    {1, 1, 1, 1, 1}

    private static int[][] floodFillDfs(int[][] grid, int sr, int sc, int color) {
        int oldColor = grid[sr][sc];
        dfs(grid, sr, sc, color, oldColor);
        return grid;
    }

    private static void dfs(int[][] grid, int r, int c, int newColor, int oldColor) {
        grid[r][c] = newColor;
        int[] dr = {0,-1, 0, 1};
        int[] dc = {1, 0,-1, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == oldColor) {
                dfs(grid, nr, nc, newColor, oldColor);
            }
        }
    }


}
