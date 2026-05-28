package com.mk.java.graph;

import java.util.List;

public class CycleInDirectedGraph {
    public static void main(String[] args) {

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 0},
                {2, 3},
                {3, 1}
        };
        DirectedGraph graph = new DirectedGraph(4, edges);

        List<List<Integer>> adj = graph.getAdj();

        graph.printGraph();

        System.out.println(isCycle(adj)? "Graph contains cycle true" : "Graph doesn't contain cycle false");

    }


    private static boolean isCycle(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        boolean[] recStack = new boolean[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i] && isCycleUtil(adj, i, visited, recStack))
                return true;
        }

        return false; // Placeholder implementation, you need to write the actual logic here
    }

    private static boolean isCycleUtil(List<List<Integer>> adj, int i, boolean[] visited, boolean[] recStack) {
        if(visited[i]) return false; // Already visited, no cycle found yet, so return false.

        if(recStack[i]) return true; // In the recursion stack,
         // it means we have encountered this vertex before, so there's a cycle. Return true.')

        visited[i] = true;
        recStack[i] = true;

        for (int neighbor : adj.get(i)) {
            if (!visited[neighbor]) {
                if (isCycleUtil(adj, neighbor, visited, recStack))
                    return true;
            } else if (recStack[neighbor]) {
                return true;
            }
        }

        recStack[i] = false;
        return false;
    }
}
