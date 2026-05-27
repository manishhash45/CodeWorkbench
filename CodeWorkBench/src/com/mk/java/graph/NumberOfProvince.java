package com.mk.java.graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvince {
    public static void main(String[] args) {
     int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
     System.out.println("Number of Province: " + new NumberOfProvince().findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        List<ArrayList<Integer>> adj = new ArrayList();
        int n = isConnected.length;
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<Integer>());

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i + 1).add(j + 1);
                }
            }

        boolean[] vis = new boolean[n + 1];
        int count = 0;
        for (int i = 1; i <= n; i++)
            if (!vis[i]) {
                count++;
                dfs(i, adj, vis);
            }
        return count;
    }
    private void dfs(int node, List<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (Integer i : adj.get(node)) {
            if (!vis[i]) {
                vis[i] = true;
                dfs(i, adj, vis);
            }
        }
    }
}
