package com.mk.java.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BipartitionGraph {
    public static void main(String[] args) {
        int[][] graph = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };

        System.out.println("Is the graph bipartite? " + isBipartite(graph));
    }

    private static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!bfs(i, color, graph))
                    return false;
            }
        }
        return true;
    }

    private static boolean bfs(int start, int[] color, int[][] graph) {
        Queue<Integer> queue = new LinkedList();
        color[start] = 1;
        queue.add(start);

        while (queue.size() > 0) {
            Integer node = queue.poll();
            for (Integer i : graph[node]) {
                if (color[i] == 0) {
                    color[i] = -color[node];
                    queue.add(i);
                }
                if (color[i] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
