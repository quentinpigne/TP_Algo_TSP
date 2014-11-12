package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> V = new ArrayList<Vertex>();
    private List<Edge> E = new ArrayList<Edge>();

    /*
        Fonctions sur les sommets
     */
    //Ajoute un sommet au graphe
    public void addVertex(Vertex vertex) {
        V.add(vertex);
    }

    //Permet de récupérer la liste des sommets
    public List<Vertex> getV() {
        return V;
    }

    //Permet de récupérer un sommet particulier
    public Vertex getVertex(int i) {
        return V.get(i);
    }

    /*
        Fonctions sur les arcs
     */
    //Ajoute un arc au graphe
    public void addEdge(Edge edge) {
        E.add(edge);
    }

    //Permet de récupérer la liste des arcs
    public List<Edge> getE() {
        return E;
    }

    //Permet de récupérer l'arc reliant deux sommets
    public Edge getEdge(Vertex v1, Vertex v2) {
        for(Edge edge : E) {
            if(edge.getStart() == v1 || edge.getStart() == v2) {
                if(edge.getEnd() == v2 || edge.getEnd() == v1) {
                    return edge;
                }
            }
        }
        return null;
    }

    //Permet de récupérer tous les arcs partants d'un sommet
    public List<Edge> getVEdge(Vertex v) {
        List<Edge> edgeList = new ArrayList<Edge>();
        for(Edge edge : E) {
            if(edge.getStart() == v) {
                edgeList.add(edge);
            }
        }
        return edgeList;
    }
}
