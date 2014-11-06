package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> V = new ArrayList<Node>();
    private List<Edge> E = new ArrayList<Edge>();

    //Modificateurs de noeuds
    public List<Node> getV() {
        return V;
    }

    public Node getNode(int i) {
        return V.get(i);
    }

    public void addNode(Node node) {
        V.add(node);
    }

    //Modificateurs d'arc
    public List<Edge> getE() {
        return E;
    }

    public void addEdge(Edge edge) {
        E.add(edge);
    }
}
