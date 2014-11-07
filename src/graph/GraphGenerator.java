package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pigneq on 21/10/14.
 */

public class GraphGenerator {

    public static Graph generate(int n, double p) throws BoundaryException {
        if(p <= 0 || p >= 1) {
            throw new BoundaryException();
        }

        Graph newGraph = new Graph();

        //Composantes connexes
        Map<Integer, List<Vertex>> composantes = new HashMap<Integer, List<Vertex>>();

        //Tirage des sommets et ajout à la liste des déconnectés
        for(int i = 0; i < n; i++) {
            Vertex newVertex = new Vertex(i, Math.random(), Math.random());
            newGraph.addVertex(newVertex);
            composantes.put(i, new ArrayList<Vertex>());
            composantes.get(i).add(newVertex);
        }

        //Tirage des arcs (pour chaque sommet 2 à 2)
        for(int i = 0; i < n; i++) {
            System.out.println(i);
            for(int j = i+1; j < n; j++) {
                if(Math.random() <= p) {
                    Edge newEdge = new Edge(newGraph.getVertex(i), newGraph.getVertex(j));
                    newGraph.addEdge(newEdge);
                    fusion(composantes, newGraph.getVertex(i), newGraph.getVertex(j));
                }
            }
        }
        System.out.print(composantes.size());
        return newGraph;
    }

    private static void fusion(Map<Integer, List<Vertex>> c, Vertex i, Vertex j) {
        int li = 0;
        int lj = 0;
        try {
            while (!c.get(li).contains(i)) {
                li++;
            }
            while (!c.get(lj).contains(j)) {
                lj++;
            }
            for (int k = 0; k < c.get(lj).size(); k++) {
                c.get(li).add(c.get(lj).get(k));
            }
        } catch (NullPointerException e) {
            System.out.println("li qui plante :" + li);
        }
        c.remove(lj);
    }
}
