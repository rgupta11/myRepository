package com.rga.q.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Depth First Search (DFS) implementation
 */
public class DFS {

    public static List<Integer> dfs(int node, List<List<Integer>> adjList, 
        boolean[] visited, List<Integer> result){
        
        visited[node] = true;
        result.add(node);
        
        for(Integer neighbor : adjList.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, adjList, visited, result);
            }
        }
        return result;
    }

    public static List<Integer> dfsMatrix(int node, int[][] adjMatrix, 
        boolean[] visited, List<Integer> result){
        
        visited[node] = true;
        result.add(node);
        int numberOfNodes = adjMatrix.length;
        for(int neighbor=0; neighbor<numberOfNodes; neighbor++){
            if(adjMatrix[node][neighbor] == 1 && !visited[neighbor]){
                dfsMatrix(neighbor, adjMatrix, visited, result);
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

    public static List<List<Integer>> createAdjList(int n){
        
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<Integer>());
        }
        adjList.get(1).add(2); //edge 1-2
        adjList.get(2).add(1); //edge 2-1
        adjList.get(1).add(3); //edge 1-3
        adjList.get(3).add(1); //edge 3-1
        adjList.get(2).add(4); //edge 2-4
        adjList.get(4).add(2); //edge 4-2
        adjList.get(2).add(5); //edge 2-5
        adjList.get(5).add(2); //edge 5-2
        adjList.get(3).add(4); //edge 3-4
        adjList.get(4).add(3); //edge 4-3 
        return adjList;
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = createAdjList(5);
        boolean[] visited = new boolean[adjList.size()];
        List<Integer> result = dfs(1, adjList, visited, new ArrayList<Integer>());
        printList("DFS", result);

        int[] arr = new int[10];
        for(int i=0; i<10; i++){
            System.out.println(arr[i]);
        }

    }
    
}
