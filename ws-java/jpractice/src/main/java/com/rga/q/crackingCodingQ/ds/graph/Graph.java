package com.rga.q.ds.graph;
import java.util.*;


public class Graph {
            
    // Adjacency list representation of the graph
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    // Add edge to the graph
    public void addEdge(int src, int dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.get(src).add(dest);
    }

    // Check if there is a route between two nodes using BFS
    public boolean hasRoute(int start, int end) {
        if (start == end) return true;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            List<Integer> neighbors = adjList.get(current);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (neighbor == end) {
                        return true;
                    }
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return false;
    }

}
