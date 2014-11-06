import graph.BoundaryException;
import graph.Graph;
import graph.GraphGenerator;
import gui.GraphGUI;

import javax.swing.*;

/**
 * Created by pigneq on 21/10/14.
 */

public class TP_Algo {
    public static void main(String[] args) {
        Graph graphe = null;
        try {
            graphe = GraphGenerator.generate(20, 0.2);
        } catch (BoundaryException e) {

        }

        GraphGUI graphGUI = new GraphGUI(graphe.getV(), graphe.getE());
        graphGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graphGUI.setSize(500, 500);
        graphGUI.setVisible(true);
    }
}
