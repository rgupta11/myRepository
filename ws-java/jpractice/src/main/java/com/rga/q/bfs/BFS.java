package com.rga.q.bfs;

import java.util.List;

/**
 * Breadth-First Search (BFS) algorithm implementation.
 * Typically used for traversing or searching tree or graph data structures.
 * The algorithm starts at the root (or an arbitrary node in the case of a graph)
 * and explores all of the neighbor nodes at the present depth prior to moving on
 * to nodes at the next depth level.
 *  Queue data structure to keep track of the nodes.
 *  Adj matrix/List to represent the graph.
 *  Visitor array (boolean)
 *
 *  Pseudocode:
 *  1. Initialize the queue and visitor array.
 *  2. Enqueue the starting node and mark it as visited.
 *  3. While the queue is not empty:
 *     a. Dequeue a node.
 *     b. Process the node (e.g., print it).
 *     c. Enqueue all unvisited neighbors and mark them as visited.
 *  4. End.
 * 
 * 0 based OR 1 based indexing for nodes.
 * Adj matrix stoes edges to node but store it as 2 records  1,2 and 2,1 for undirected graph.
 */
public class BFS {
    

    public static List<Integer> bfsMatrix(int startNode, int[][] adjMatrix, boolean[] visited){
        int numberOfNodes = adjMatrix.length;
        java.util.Queue<Integer> queue = new java.util.LinkedList<Integer>();
        queue.add(startNode);
        visited[startNode] = true;
        List<Integer> result = new java.util.ArrayList<Integer>();

        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            //System.out.print(currentNode + " ");
            result.add(currentNode);

            for(int neighbor=0; neighbor<numberOfNodes; neighbor++){
                if(adjMatrix[currentNode][neighbor] == 1 && !visited[neighbor]){
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return result;
    }

    public static List<Integer> bfsList(int startNode, java.util.List<java.util.List<Integer>> adjList, boolean[] visited){
        
        java.util.Queue<Integer> queue = new java.util.LinkedList<Integer>();
        queue.add(startNode);
        visited[startNode] = true;
        List<Integer> result = new java.util.ArrayList<Integer>();

        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            //System.out.print(currentNode + " ");
            result.add(currentNode);
            for(int neighbor: adjList.get(currentNode)){
                if(!visited[neighbor]){
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return result;
    }

    public static void printList(String msg, List<Integer> list){
        System.out.println("-----" + msg + "-----");
        for(int node: list){
            System.out.print(node + " ");
        }
        System.out.println("");
    }

    public static int[][] createAdjMatrix(int n){

        int[][] adjMatrix = new int[n+1][n+1]; //1 based indexing -> n+1,m+1 | if 0 then n,m
        adjMatrix[1][2] = 1; //edge 1-2
        adjMatrix[2][1] = 1; //edge 2-1
        adjMatrix[1][3] = 1; //edge 1-3
        adjMatrix[3][1] = 1; //edge 3-1
        adjMatrix[2][4] = 1; //edge 2-4
        adjMatrix[4][2] = 1; //edge 4-2
        adjMatrix[2][5] = 1; //edge 2-5
        adjMatrix[5][2] = 1; //edge 5-2
        adjMatrix[3][4] = 1; //edge 3-4
        adjMatrix[4][3] = 1; //edge 4-3
        return adjMatrix;
    }

    public static List<List<Integer>> createAdjList(int n){
        
        java.util.List<java.util.List<Integer>> adjList = new java.util.ArrayList<java.util.List<Integer>>();
        //For 1 based indexing | 0 based -> i=0 to <n
        for(int i=0; i<=n; i++){
            adjList.add(new java.util.ArrayList<Integer>());
        }
        adjList.get(1).add(2); // Neighbors of node 1
        adjList.get(2).add(1); // Neighbors of node 2
        adjList.get(1).add(3); // Neighbors of node 1
        adjList.get(3).add(1); // Neighbors of node 3
        adjList.get(3).add(4); // Neighbors of node 3
        adjList.get(4).add(3); // Neighbors of node 4
        adjList.get(4).add(5); // Neighbors of node 4
        adjList.get(5).add(4); // Neighbors of node 5
        adjList.get(2).add(5); // Neighbors of node 2
        adjList.get(5).add(2); // Neighbors of node 5
        return adjList;
    }

    public static void main(String[] args) {
        //Matrix representation - uses too much space for large graphs
        int[][] adjMatrix = createAdjMatrix(5);
        boolean[] visited = new boolean[adjMatrix.length];
        List<Integer> result = bfsMatrix(1, adjMatrix, visited);
        printList("AdjMatrix", result);

        //List representation
        java.util.List<java.util.List<Integer>> adjList = createAdjList(5);
        boolean[] visitedList = new boolean[adjList.size()];
        result = bfsList(1, adjList, visitedList);
        printList("AdjList", result);
    }

}
