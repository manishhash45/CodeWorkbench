package com.mk.java.graph;

import java.util.LinkedList;
import java.util.Queue;
//Output: [[1, 0, 0, 1],
//        [0, 0, 1, 1],
//        [1, 1, 0, 0]]
public class FindDistanceFromOne {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };

        printGrid(grid);
        int[][] result = findDistance(grid);

        System.out.println("Distance from the source cell to all other cells having 1:");

        printGrid(result);
    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static int[][] findDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Node> q = new LinkedList<>();

        // Step 1: Push all cells having 1 into queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};

        // Step 2: BFS
        while (!q.isEmpty()) {
            Node node = q.poll();
            int row = node.first;
            int col = node.second;
            int steps = node.third;

            dist[row][col] = steps;

            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Node(nrow, ncol, steps + 1));
                }
            }
        }

        return dist;
    }


}

class Node {
    int first;
    int second;
    int third;

    Node(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}
