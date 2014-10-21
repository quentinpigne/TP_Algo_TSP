package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pigneq on 21/10/14.
 */

class Node {
    private int x;
    private int y;

    private Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class Edge {
    private Node start;
    private Node end;
    private double distance;

    private Edge(Node start, Node end) {
        this.start = start;
        this.end = end;
        this.distance = Math.sqrt(Math.pow((start.getX()-end.getX()),2) + Math.pow((start.getY()-end.getY()),2));
    }
}

public class Graph {
    private List<Node> V = new LinkedList<Node>();
    private List<Edge> E = new LinkedList<Edge>();

    public Graph() {
    }

    public void addNode(Node node) {
        V.add(node);
    }

    public void addEdge(Node start, Node end) {
        E.add(new Edge(start, end));
    }
}
