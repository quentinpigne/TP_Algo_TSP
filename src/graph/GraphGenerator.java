package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pigneq on 21/10/14.
 */

public class GraphGenerator {
    public static Graph generate(int n, double p) throws BoundaryException {
        List<Node> connect = new LinkedList<Node>();
        List<Node> disconnect = new LinkedList<Node>();

        if(p <= 0 || p >= 1) {
            throw new BoundaryException();
        }

        Graph newGraph = new Graph();

        //Tirage des sommets et ajout à la liste des déconnectés
        for(int i = 0; i < n; i++) {
            Node newNode = new Node(Math.random(), Math.random());
            newGraph.addNode(newNode);
            disconnect.add(newNode);
        }

        //Ajout d'un sommet aléatoire à la liste des connectés


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
