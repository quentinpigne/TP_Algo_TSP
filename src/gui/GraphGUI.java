package gui;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import graph.Edge;
import graph.Node;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by quentin on 06/11/14.
 */

public class GraphGUI extends JFrame {
    public GraphGUI(List<Node> V, List<Edge> E) {
        super("Graphe généré aléatoirement");

        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        List<Object> vertexList = new ArrayList<Object>();
        List<Object> edgeList = new ArrayList<Object>();

        graph.getModel().beginUpdate();
        try {
            for(Node node : V) {
                Object v = graph.insertVertex(parent, null, null, 500*node.getX(), 500*node.getY(), 10, 10);
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
