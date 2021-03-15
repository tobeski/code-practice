package com.eltobeski.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    // A List of Lists to represent an adjacency list
    List<List<Integer>> adjList = null;

    // Constructor
    public Graph(List<Edge> edges, int N) {
        adjList = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            adjList.add(i, new ArrayList<>());
        }

        // add edges to the undirected graph
        for (int i = 0; i < edges.size(); i++) {

            int src = edges.get(i).source;
            int dest = edges.get(i).dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src); // This line of code is hear because it is undirected. Should be commented if directed.
        }
    }

    //Here the edges are sent as an array of arrays containing src in index 0 and destination in index 1
    public Graph(int[][] edges, int N) {
        //int numberOfEdges = edges.length;

        adjList = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            adjList.add(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);//edge[0] = src, edge[1] = dest
            adjList.get(edge[1]).add(edge[0]);
        }
    }


}