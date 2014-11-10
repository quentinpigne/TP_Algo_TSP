package graph;

import java.util.*;

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
            Vertex newVertex = new Vertex(i, i, Math.random(), Math.random());
            newGraph.addVertex(newVertex);
        }

        //Tirage des arcs (pour chaque sommet 2 à 2)
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(Math.random() <= p) {
                    Vertex vi = newGraph.getVertex(i);
                    Vertex vj = newGraph.getVertex(j);
                    Edge newEdge = new Edge(vi, vj);
                    newGraph.addEdge(newEdge);
                    for(Vertex v : newGraph.getV()) {
                        if(v.getIdC() == vj.getIdC()) {
                            v.setIdC(vi.getIdC());
                        }

                    }

                }
            }
        }

        //Calcul du nombre de composantes connexes
        Set<Integer> list_comp = new HashSet<Integer>();
        for(Vertex v : newGraph.getV()) {
            list_comp.add(v.getIdC());
        }

        System.out.println("Nombre de composantes connexes avant connexification : " + list_comp.size());

        //Connexification du graphe
        int idC_final = newGraph.getV().get(0).getIdC();
        for(Vertex v : newGraph.getV()) {
            if(v.getIdC() != idC_final) {
            }
        }

        //Affichage pour chaque noeud de l'ID et de sa composante connexe
        for(Vertex v : newGraph.getV()) {
            System.out.println("Noeud " + v.getId() + " -> composante : " + v.getIdC());
        }

        return newGraph;
    }
}
