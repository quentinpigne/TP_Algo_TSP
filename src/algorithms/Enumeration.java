package algorithms;

import graph.Edge;
import graph.Graph;
import graph.Path;
import graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Enumeration {
    public static Path enumeration(Graph g) {
        //Création de la liste des chemins
        List<Path> listPath = new ArrayList<Path>();
        List<Vertex> listVertex = new ArrayList<Vertex>();
        findAllPaths(listPath, listVertex, g);

        //Recherche du plus court chemin parmis tous ceux calculés
        Path finalPath = listPath.get(0);
        for(Path path : listPath) {
            if(path.getLength() < finalPath.getLength()) finalPath = path;
        }
        return finalPath;
    }

    private static void findAllPaths(List<Path> listPath, List<Vertex> listVertex, Graph g) {
        for(Vertex v : g.getV()) {
            if(!listVertex.contains(v)) {
                for(Edge edge : g.getVEdge(v)) {

                }
            }
        }
    }
}
