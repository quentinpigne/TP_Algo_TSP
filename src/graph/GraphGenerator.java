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
        int nb_comp = list_comp.size();

        System.out.println("Nombre de composantes connexes avant connexification : " + nb_comp);

        //Connexification du graphe
        while(nb_comp > 1) {
            //Tirage de deux sommets au hasard
            // (on force V1 à être un sommet de la composante connexe du sommet 0 et V2 à ne pas l'être)
            int randomV1 = (int)(n * Math.random());
            while(newGraph.getV().get(randomV1).getIdC() != newGraph.getV().get(0).getIdC()) {
                randomV1 = (int)(n * Math.random());
            }
            int randomV2 = (int)(n * Math.random());
            while(newGraph.getV().get(randomV2).getIdC() == newGraph.getV().get(0).getIdC()) {
                randomV2 = (int)(n * Math.random());
            }
            //On fusionne avec une probabilité p
            if(Math.random() <= p) {
                System.out.println("Ajout d'un arc !");
                Vertex vi = newGraph.getVertex(randomV1);
                Vertex vj = newGraph.getVertex(randomV2);
                Edge newEdge = new Edge(vi, vj);
                newGraph.addEdge(newEdge);
                for(Vertex v : newGraph.getV()) {
                    if (v.getIdC() == vj.getIdC()) {
                        v.setIdC(vi.getIdC());
                    }
                }
                //Recalcul du nombre de composantes connexes
                list_comp = new HashSet<Integer>();
                for(Vertex v : newGraph.getV()) {
                    list_comp.add(v.getIdC());
                }
                nb_comp = list_comp.size();
            }
        }

        System.out.println("Nombre de composantes connexes après connexification : " + nb_comp);

        //Affichage pour chaque noeud de l'ID et de sa composante connexe
        for(Vertex v : newGraph.getV()) {
            System.out.println("Noeud " + v.getId() + " -> composante : " + v.getIdC());
        }

        return newGraph;
    }
}
