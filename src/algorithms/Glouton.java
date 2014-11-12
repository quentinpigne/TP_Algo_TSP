package algorithms;

import graph.Edge;
import graph.Graph;
import graph.Path;

public class Glouton {
    public static Path glouton(Graph g) {
        Path p = new Path();
        for (int i = 0; i < g.getV().size(); i++) {
            Edge e_min = g.getVEdge(g.getVertex(i)).get(0);
            for(Edge e : g.getVEdge(g.getVertex(i))) {
                if(e.getDistance() < e_min.getDistance()) e_min = e;
            }
            p.addEdge(e_min);
        }
        return p;
    }
}
