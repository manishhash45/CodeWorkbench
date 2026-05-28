package com.mk.java.graph;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph {
    private int V;  // Number of vertices
    private List<List<Integer>> adj; // Adjacency list
    private List<Boolean> visited; // To keep track of visited vertices

    public DirectedGraph(int V,int[][] edges) {
        this.V = V;
        adj = new ArrayList<>();
        visited = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(i, new ArrayList<>());
        }
        createGraph(edges);
    }

    private void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public void createGraph(int[][] edges) {
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
        }
    }
//    {0, 1},
//    {1, 2},
//    {2, 0},
//    {2, 3},
//    {3, 1}

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int v : adj.get(i)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> getAdj() {
        return adj;
    }

}
