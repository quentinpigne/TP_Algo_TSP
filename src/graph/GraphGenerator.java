package graph;

/**
 * Created by pigneq on 21/10/14.
 */

public class GraphGenerator {
    public static Graph generate(int n, double p) throws BoundaryException {
        if(p <= 0 || p >= 1) {
            throw new BoundaryException();
        }

        Graph newGraph = new Graph();

        //Tirage des sommets
        for(int i = 0; i < n; i++) {
            newGraph.addNode(Math.random(), Math.random());
        }

        //Tirage des arcs (pour chaque sommet 2 à 2)
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(Math.random() <= p) {
                    Edge newEdge = new Edge(newGraph.getNode(i), newGraph.getNode(j));
                }
            }
        }

        return newGraph;
    }
}
