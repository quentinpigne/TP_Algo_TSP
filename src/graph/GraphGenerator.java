package graph;

import java.util.Random;

/**
 * Created by pigneq on 21/10/14.
 */

public class GraphGenerator {
    private Random r;
    private int n;
    private double p;

    public GraphGenerator(int n, double p) {
        this.n = n;
        this.p = p;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setP(double p) {
        this.p = p;
    }

    public Graph generate() {
        Graph graph = new Graph();

        for(int i = 0; i < n; i++) {
            Node newNode = new Node(r.nextDouble(), r.nextDouble());
            graph.addNode(newNode);
        }
    }
}
