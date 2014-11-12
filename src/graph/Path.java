package graph;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<Vertex> V = new ArrayList<Vertex>();
    private List<Edge> E = new ArrayList<Edge>();
    private double length = 0;

    public List<Vertex> getV() {
        return V;
    }

    public List<Edge> getE() {
        return E;
    }

    public double getLength() {
        return length;
    }

    public void addEdge(Edge edge) {
        //Si c'est le premier arc, on ajoute le premier sommet au chemin
        if(V.isEmpty()) {
            V.add(edge.getStart());
        }

        //On ajoute l'arc uniquement si son sommet de départ est le dernier sommet du chemin
        if(V.get(V.size()-1) == edge.getStart() || V.get(V.size()-1) == edge.getEnd()) {
            V.add(edge.getEnd());
            E.add(edge);
            length += edge.getDistance();
        }
    }
}
