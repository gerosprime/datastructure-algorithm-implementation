package com.gerosprime.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjacencyList {

    public static final int STATE_UNDISCOVERED = 0;
    public static final int STATE_DISCOVERED = 1;
    public static final int STATE_PROCESSED = 2;

    private int vertices;
    private boolean direct;

    private int[] state;

    private List<List<Edge>> edges;

    public GraphAdjacencyList(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++)
            edges.add(new ArrayList<>());

        state = new int[vertices];
    }

    public boolean addEdge(int u, int v, boolean direct) {

        List<Edge> edges = this.edges.get(u);

        edges.add(new Edge(v, 0));
        if (!direct)
            return addEdge(v, u, false);
        else
            return true;

    }

    public List<List<Edge>> getEdges() {
        return edges;
    }

    public int getVertices() {
        return vertices;
    }

    public boolean isDirect() {
        return direct;
    }

    public int[] getState() {
        return state;
    }

    public void clearState() {
        for (int i = 0; i < state.length; i++) {
            state[i] = STATE_UNDISCOVERED;
        }
    }
}
