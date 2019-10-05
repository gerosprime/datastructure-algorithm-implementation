package com.gerosprime.dsa.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        GraphAdjacencyList graphAdjacencyList = new GraphAdjacencyList(5);

        graphAdjacencyList.addEdge(0, 2, true);
        graphAdjacencyList.addEdge(0, 1, true);
        graphAdjacencyList.addEdge(3, 2, true);
        graphAdjacencyList.addEdge(1, 3, true);
        graphAdjacencyList.addEdge(4, 3, true);

        new BreadthFirstSearch().traverse(graphAdjacencyList);
    }


    public void traverse(GraphAdjacencyList graphAdjacencyList) {

        graphAdjacencyList.clearState();
        Queue<Integer> queue = new LinkedList<>();

        int vertices = graphAdjacencyList.getVertices();
        int[] state = graphAdjacencyList.getState();

        queue.add(0);

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();
            state[poll] = GraphAdjacencyList.STATE_PROCESSED;
            System.out.println(poll + " ");
            List<Edge> edges = graphAdjacencyList.getEdges().get(poll);
            for (Edge edge : edges) {
                int vertex = edge.getVertex();
                if (state[vertex] == 0) {
                    queue.offer(vertex);
                    state[vertex] = GraphAdjacencyList.STATE_DISCOVERED;
                }

            }
        }
    }

}
