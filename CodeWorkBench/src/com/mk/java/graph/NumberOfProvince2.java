package com.mk.java.graph;

import java.util.ArrayList;
import java.util.List;
// approach with matrix representation  TC: O(V^2), SC: O(V)
public class NumberOfProvince2 {
    public static void main(String[] args) {
     int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
     System.out.println("Number of Province: " + new NumberOfProvince2().findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, isConnected, vis);
            }
        }

        return count;
    }

    private void dfs(int node, int[][] graph, boolean[] vis) {
        vis[node] = true;

        for (int j = 0; j < graph.length; j++) {
            if (graph[node][j] == 1 && !vis[j]) {
                dfs(j, graph, vis);
            }
        }
    }
}
