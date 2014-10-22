package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pigneq on 21/10/14.
 */

class Node {
    private double x;
    private double y;

    public Node(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) throws BoundaryException {
        if(x >= 0 && x <= 1) {
            this.x = x;
        } else {
            throw new BoundaryException();
        }
    }

    public void setY(double y) throws BoundaryException {
        if(y >= 0 && y <= 1) {
            this.y = y;
        } else {
            throw new BoundaryException();
        }
    }
}

class Edge {
    private Node start;
    private Node end;
    private double distance;

    public Edge(Node start, Node end) {
        this.start = start;
        this.end = end;
        computeDistance();
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    public double getDistance() {
        return distance;
    }

    public void setStart(Node start) {
        this.start = start;
        computeDistance();
    }

    public void setEnd(Node end) {
        this.end = end;
        computeDistance();
    }

    private void computeDistance() {
        this.distance = Math.sqrt(Math.pow((start.getX()-end.getX()),2) + Math.pow((start.getY()-end.getY()),2));
    }
}

public class Graph {
    private List<Node> V = new LinkedList<Node>();
    private List<Edge> E = new LinkedList<Edge>();

    public void addNode(double x, double y) {
        V.add(new Node(x, y));
    }

    public void addEdge(Node start, Node end) {
        E.add(new Edge(start, end));
    }
}
