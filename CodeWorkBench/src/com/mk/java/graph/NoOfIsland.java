package com.mk.java.graph;

public class NoOfIsland {

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '0', '0'}};  //3

        System.out.println("Number of Islands: " + new NoOfIsland().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int count = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    dfs(i, j, grid, vis);  // dfs for all adjacent '1's starting from current cell.
                }

        return count;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] vis) {
        vis[i][j] = true;
        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};

        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];

            if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1' && !vis[nr][nc])
                dfs(nr, nc, grid, vis); // recursively visit all adjacent '1's.
        }

    }

    public int numIslands1(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    count++;
                    dfs1(i, j, grid); // dfs for all adjacent '1's starting from current cell.
                }

        return count;
    }

    private void dfs1(int i, int j, char[][] grid) {
        int[] dr = { 0, -1, 0, 1 };
        int[] dc = { 1, 0, -1, 0 };

        grid[i][j] = '0';

        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];

            if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1' )
                dfs1(nr, nc, grid); // recursively visit all adjacent '1's.
        }
    }
}


