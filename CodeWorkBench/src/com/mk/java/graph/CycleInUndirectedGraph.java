package com.mk.java.graph;

import java.util.ArrayList;

public class CycleInUndirectedGraph {


    public static void main(String[] args) {     //O(V+E) Time and O(V) Space
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Add edges
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);

        System.out.print(isCycle(adj) ? "true" : "false");
    }

    private static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];

        for (int i = 0; i < adj.size(); i++)
        {
            if (!vis[i])
                if (isCycleExist(adj, i, vis, -1))
                    return true;
        }


        return false;
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    private static boolean isCycleExist(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, int parent) {
        vis[node] = true;
        for(Integer i : adj.get(node)) {
            if(!vis[i])
            {
                if(isCycleExist(adj, i, vis, node))
                    return true;
            }else if(i!=parent)
            {
                return true;
            }
        }
        return false;
    }


}
