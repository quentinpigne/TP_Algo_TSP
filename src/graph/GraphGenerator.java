package graph;

import java.util.Random;

/**
 * Created by pigneq on 21/10/14.
 */

public class GraphGenerator {
    private static Random r = new Random();

    public static Graph generate(int n, double p) {
        Graph newGraph = new Graph();

        for(int i = 0; i < n; i++) {
            newGraph.addNode(r.nextDouble(), r.nextDouble());
        }

        return newGraph;
    }
}
