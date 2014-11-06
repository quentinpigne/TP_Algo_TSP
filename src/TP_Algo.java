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
            graphe = GraphGenerator.generate(10, 0.5);
        } catch (BoundaryException e) {

        }

        GraphGUI graphGUI = new GraphGUI(graphe.getV(), graphe.getE());
        graphGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graphGUI.setSize(400, 320);
        graphGUI.setVisible(true);
    }
}
