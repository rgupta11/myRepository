package com.rga.q.dfs;

import java.util.ArrayList;
import java.util.List;

/** Find out diff provinces in a graph 
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 
 * if the ith city and the jth city are directly connected, and isConnected[i][j] = 0
 * otherwise.
 * Return the total number of provinces.
 * Using DFS approach
 */
public class Province {

    public static int findProvinces(List<List<Integer>> adjList) {
        int n = adjList.size();
        boolean[] visited = new boolean[n];
        int provinceCount = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS.dfs(i, adjList, visited, result);
                provinceCount++; // Found a new province. 
                // all disconnected nodes will be marked visited
                // so next unvisited node indicates a new province
            }
        }
        return provinceCount;
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = DFS.createAdjList(5);
        int provinces = findProvinces(adjList);
        System.out.println("Total Provinces: " + provinces);
    }
    
}
