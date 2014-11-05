package graph;

public class Edge {
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
