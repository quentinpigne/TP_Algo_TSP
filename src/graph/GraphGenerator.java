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

        //Création de la matrice des distances entre sommets
        double[][] distMatrix = new double[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) distMatrix[i][j] = 0;
                else distMatrix[i][j] = Integer.MAX_VALUE;
            }
        }

        //Tirage des arcs (pour chaque sommet 2 à 2)
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(Math.random() <= p) {
                    Vertex vi = newGraph.getVertex(i);
                    Vertex vj = newGraph.getVertex(j);
                    Edge newEdge = new Edge(vi, vj);
                    distMatrix[i][j] = newEdge.getDistance();

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
                Vertex vi = newGraph.getVertex(randomV1);
                Vertex vj = newGraph.getVertex(randomV2);
                Edge newEdge = new Edge(vi, vj);
                distMatrix[randomV1][randomV2] = newEdge.getDistance();

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

        //Symétrisation de la matrice (car le graphe est non-orienté)
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(distMatrix[i][j] == Integer.MAX_VALUE) {
                    distMatrix[i][j] = distMatrix[j][i];
                }
            }
        }

        //Algorithme de Floyd-Warshall pour compléter le graph
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(distMatrix[i][k] == Integer.MAX_VALUE || distMatrix[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (distMatrix[i][j] > distMatrix[i][k] + distMatrix[k][j]) {
                        distMatrix[i][j] = distMatrix[i][k] + distMatrix[k][j];
                    }
                }
            }
        }

        //Création des arcs à partir de la matrice des distances
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(i != j) {
                    Edge newEdge = new Edge(newGraph.getVertex(i), newGraph.getVertex(j));
                    newEdge.setDistance(distMatrix[i][j]);
                    newGraph.addEdge(newEdge);
                }
            }
        }
        newGraph.setDistanceMatrix(distMatrix);
        return newGraph;
    }
}
