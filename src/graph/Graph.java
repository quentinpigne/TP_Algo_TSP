package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> V = new ArrayList<Vertex>();
    private List<Edge> E = new ArrayList<Edge>();
    private double[][] distanceMatrix;

    //Getters / Setters de sommets
    public List<Vertex> getV() {
        return V;
    }

    public Vertex getVertex(int i) {
        return V.get(i);
    }

    public void addVertex(Vertex vertex) {
        V.add(vertex);
    }

    //Getters / Setters d'arc
    public List<Edge> getE() {
        return E;
    }

    public void addEdge(Edge edge) {
        E.add(edge);
    }

    public double[][] getDistanceMatrix() {
        return distanceMatrix;
    }

    public void setDistanceMatrix(double[][] distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }
}
