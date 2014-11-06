package graph;

public class Edge {
    private Vertex start;
    private Vertex end;
    private double distance;

    public Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
        computeDistance();
    }

    public Vertex getStart() {
        return start;
    }

    public Vertex getEnd() {
        return end;
    }

    public double getDistance() {
        return distance;
    }

    public void setStart(Vertex start) {
        this.start = start;
        computeDistance();
    }

    public void setEnd(Vertex end) {
        this.end = end;
        computeDistance();
    }

    private void computeDistance() {
        this.distance = Math.sqrt(Math.pow((start.getX()-end.getX()),2) + Math.pow((start.getY()-end.getY()),2));
    }
}
