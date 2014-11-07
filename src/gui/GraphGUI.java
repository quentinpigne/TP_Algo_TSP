package gui;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import graph.Edge;
import graph.Vertex;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by quentin on 06/11/14.
 */

public class GraphGUI extends JFrame {
    public GraphGUI(List<Vertex> V, List<Edge> E) {
        super("Visualisation du graphe");

        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        List<Object> vertexList = new ArrayList<Object>();
        List<Object> edgeList = new ArrayList<Object>();

        graph.getModel().beginUpdate();
        try {
            for(Vertex vertex : V) {
                Object v = graph.insertVertex(parent, null, vertex.getId(), 500* vertex.getX(), 500* vertex.getY(), 10, 10);
                vertexList.add(v);
            }
            for(Edge edge : E) {
                Object e = graph.insertEdge(parent, null, null, vertexList.get(edge.getStart().getId()), vertexList.get(edge.getEnd().getId()));
            }
        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);
    }
}
