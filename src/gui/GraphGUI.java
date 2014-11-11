package gui;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import graph.Edge;
import graph.Vertex;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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
                Object v = graph.insertVertex(parent, null, vertex.getId(), 700* vertex.getX(), 700* vertex.getY(), 20, 20, mxConstants.STYLE_SHAPE + "=" + mxConstants.SHAPE_ELLIPSE);
                vertexList.add(v);
            }
            for(Edge edge : E) {
                Object e = graph.insertEdge(parent, null, edge.getDistance(), vertexList.get(edge.getStart().getId()), vertexList.get(edge.getEnd().getId()), mxConstants.STYLE_ENDARROW + "=" + mxConstants.NONE);
                edgeList.add(e);
            }
        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);
    }
}
