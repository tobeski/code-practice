package com.eltobeski.LeetCode;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;

public class BiPartite {
    public static boolean findBipartite(Graph graph,int v,boolean[] discovered,boolean[] color){

        discovered[v] = true;
        for(int connects : graph.adjList.get(v)){
            if(!discovered[connects]){
                discovered[connects] = true;
                color[connects] = !color[v];
                if(!findBipartite(graph,connects,discovered,color))
                    return false;
            }
            else if (color[connects]==color[v]){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(2, 3), new Edge(2, 8),
                new Edge(3, 4), new Edge(4, 6), new Edge(5, 7),
                new Edge(5, 9), new Edge(8, 9)
//                , new Edge(2, 4)
                // if we remove 2->4 edge, graph is become Bipartite
        );

        // Set number of vertices in the graph
        final int N = 10;
        // create a graph from edges
        Graph graph = new Graph(edges, N);

        // stores vertex is discovered or not
        boolean[] discovered = new boolean[N];

        // stores color 0 or 1 of each vertex in BFS
        boolean[] color = new boolean[N];

        // mark source vertex as discovered and
        // set its color to 0
        discovered[0] = true;
        color[0] = false;

        // start DFS traversal from any node as graph
        // is connected and undirected
        if (findBipartite(graph, 1, discovered, color))
            System.out.println("Bipartite Graph");
        else
            System.out.println("Not a Bipartite Graph");
    }
}
