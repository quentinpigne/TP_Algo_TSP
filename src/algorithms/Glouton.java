package algorithms;

import graph.Edge;
import graph.Graph;
import graph.Path;
import graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Glouton {
    public static Path glouton(Graph g) {
        Path p = new Path();

        //On crée la liste des sommets déjà visités
        List<Vertex> vertexList = new ArrayList<Vertex>();

        //On commence par le premier sommet
        Vertex v = g.getVertex(0);
        Edge e_min = g.getVEdge(v).get(0);
        for(Edge e : g.getVEdge(v)) {
            if(e.getDistance() < e_min.getDistance()) e_min = e;
        }
        vertexList.add(v);
        if(e_min.getStart() == v) v = e_min.getEnd();
        else v = e_min.getStart();
        p.addEdge(e_min);

        //On itère ensuite sur tous les autres sommets
        for(int i = 1; i < g.getV().size(); i++) {
            //On prend le premier arc dont l'extrémité n'a pas été visitée comme plus petit
            for(int j = 0; j < g.getVEdge(v).size(); j++) {
                e_min = g.getVEdge(v).get(j);
                if(!vertexList.contains(e_min.getStart()) && !vertexList.contains(e_min.getEnd())) break;
            }

            //On cherche le plus petit parmis les arcs (hormis ceux déjà visités)
            for(Edge e : g.getVEdge(v)) {
                if(vertexList.size() != g.getV().size()) {
                    if(!vertexList.contains(e.getStart()) && !vertexList.contains(e.getEnd())) {
                        if(e.getDistance() < e_min.getDistance()) e_min = e;
                    }
                } else {
                    if(e.getStart() == g.getVertex(0) || e.getEnd() == g.getVertex(0)) {
                        e_min = e;
                    }
                }
            }
            System.out.println(e_min.getDistance());
            if(e_min.getStart() == v) v = e_min.getEnd();
            else v = e_min.getStart();
            vertexList.add(v);
            p.addEdge(e_min);
        }
        return p;
    }
}
