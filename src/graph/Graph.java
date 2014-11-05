package graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private List<Node> V = new LinkedList<Node>();
    private List<Edge> E = new LinkedList<Edge>();

    public Node getNode(int i) {
        return V.get(i);
    }

    public void addNode(double x, double y) {
        V.add(new Node(x, y));
    }

    public void addEdge(Node start, Node end) {
        E.add(new Edge(start, end));
    }
}
