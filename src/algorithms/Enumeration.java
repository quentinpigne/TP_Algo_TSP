package algorithms;

import graph.Edge;
import graph.Graph;
import graph.Path;
import graph.Vertex;

import java.util.ArrayList;
import java.util.List;

/*
Idée de l'algo :
- Trouver les n combinaisons de n parmis n sommets
- Créer une liste de n! chemins
- Remplir les chemins avec les arcs -> calcul des longueurs
- Trouver le chemin de longueur minimale
 */

public class Enumeration {
    public static Path enumeration(Graph g) {
        //Création d'une liste de liste de sommets
        List<List<Vertex>> vertexLists = new ArrayList<List<Vertex>>();
        for (int i = 0; i < factorielle(g.getV().size()); i++) {
            vertexLists.add(new ArrayList<Vertex>());
        }

        //Recherche des n combinaisons de n parmis n sommets


        //Création de la liste de n! chemins
        List<Path> listPath = new ArrayList<Path>();
        for (int i = 0; i < factorielle(g.getV().size()); i++) {
            listPath.add(new Path());
        }

        //Remplissage des chemins pour les n! listes de sommets

        //Recherche du plus court chemin parmis tous ceux calculés
        Path finalPath = listPath.get(0);
        for(Path path : listPath) {
            if(path.getLength() < finalPath.getLength()) finalPath = path;
        }
        return finalPath;
    }

    private static int factorielle(int n)
    {
        if(n>1)
            return n*factorielle(n - 1);
        else
            return 1;
    }
}
