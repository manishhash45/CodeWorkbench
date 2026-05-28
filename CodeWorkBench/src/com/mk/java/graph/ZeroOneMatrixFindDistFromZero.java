package com.mk.java.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrixFindDistFromZero {

    public static void main(String[] args) {
        //[[0,0,0],//OUT PUT
        // [0,1,0],
        // [1,2,1]]
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        printMatrix(matrix);

        int[][] result = updateMatrix(matrix);
        System.out.println("Minimum distance from a zero cell to all other cells is ");

        printMatrix(result);
    }


    private static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }


    private static int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        int[][] dist = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j, 0});
                    vis[i][j] = true;
                }
            }
        }

        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};


        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int r = node[0];
            int c = node[1];
            int d = node[2];
            dist[r][c] = d;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]) {
                    queue.add(new int[]{nr, nc, d + 1});
                    vis[nr][nc] = true;
                }
            }


        }
        return dist;
    }
}
