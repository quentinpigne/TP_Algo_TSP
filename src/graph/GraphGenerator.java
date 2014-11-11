package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphGenerator {

    public static Graph generate(int n, double p) throws BoundaryException {
        if(p <= 0 || p >= 1) {
            throw new BoundaryException();
        }

        Graph newGraph = new Graph();
        List<Integer> vertexComp = new ArrayList<Integer>();

        //Tirage des sommets
        for(int i = 0; i < n; i++) {
            Vertex newVertex = new Vertex(i, Math.random(), Math.random());
            newGraph.addVertex(newVertex);
            vertexComp.add(i);
        }

        //Tirage des arcs (pour chaque sommet 2 à 2)
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(Math.random() <= p) {
                    Vertex vi = newGraph.getVertex(i);
                    Vertex vj = newGraph.getVertex(j);
                    Edge newEdge = new Edge(vi, vj);
                    newGraph.addEdge(newEdge);

                    //Fusion de deux composantes connexes
                    for(int k = 0; k < n; k++) {
                        if(vertexComp.get(k) == vertexComp.get(j)) {
                            vertexComp.set(k, vertexComp.get(i));
                        }
                    }
                }
            }
        }

        //Calcul du nombre de composantes connexes
        Set<Integer> list_comp = new HashSet<Integer>();
        for(int i = 0; i < n; i++) {
            list_comp.add(vertexComp.get(i));
        }
        int nb_comp = list_comp.size();

        System.out.println("Nombre de composantes connexes avant connexification : " + nb_comp);

        //Connexification du graphe
        while(nb_comp > 1) {
            //Tirage de deux sommets au hasard
            // (on force V1 à être un sommet de la composante connexe du sommet 0 et V2 à ne pas l'être)
            int randomV1 = (int)(n * Math.random());
            while(vertexComp.get(randomV1) != vertexComp.get(0)) {
                randomV1 = (int)(n * Math.random());
            }
            int randomV2 = (int)(n * Math.random());
            while(vertexComp.get(randomV2) == vertexComp.get(0)) {
                randomV2 = (int)(n * Math.random());
            }

            //On fusionne selon une probabilité p
            if(Math.random() <= p) {
                //Ajout d'un arc
                System.out.println("Ajout d'un arc !");
                Vertex vi = newGraph.getVertex(randomV1);
                Vertex vj = newGraph.getVertex(randomV2);
                Edge newEdge = new Edge(vi, vj);
                newGraph.addEdge(newEdge);

                //Fusion de deux composantes connexes
                for(int i = 0; i < n; i++) {
                    if(vertexComp.get(i) == vertexComp.get(randomV2)) {
                        vertexComp.set(i, vertexComp.get(randomV1));
                    }
                }

                //Recalcul du nombre de composantes connexes
                list_comp = new HashSet<Integer>();
                for(int i = 0; i < n; i++) {
                    list_comp.add(vertexComp.get(i));
                }
                nb_comp = list_comp.size();
            }
        }

        System.out.println("Nombre de composantes connexes après connexification : " + nb_comp);

        //Affichage pour chaque noeud de l'ID et de sa composante connexe
        for(int i = 0; i < n; i++) {
            System.out.println("Noeud " + i + " -> composante : " + vertexComp.get(i));
        }

        return newGraph;
    }
}
