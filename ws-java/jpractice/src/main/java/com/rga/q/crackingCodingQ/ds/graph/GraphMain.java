package com.rga.q.ds.graph;

public class GraphMain {
    

    public static void main(String[] args) {
        
        //Given a directed graph, design an algorithm to 
        // find out whether there is a route between 
        // two nodes.

        // Create a graph and test the route finding algorithm
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        
    }

}
