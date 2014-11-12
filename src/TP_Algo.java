import algorithms.Enumeration;
import algorithms.Glouton;
import graph.BoundaryException;
import graph.Graph;
import graph.GraphGenerator;
import gui.GraphGUI;

import javax.swing.*;

public class TP_Algo {
    public static void main(String[] args) {
        Graph graphe = null;
        try {
            graphe = GraphGenerator.generate(4, 0.5);
        } catch (BoundaryException e) {

        }

        System.out.println("TSP = " + Glouton.glouton(graphe).getLength());

        GraphGUI graphGUI = new GraphGUI(graphe.getV(), graphe.getE());
        graphGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graphGUI.setSize(750, 750);
        graphGUI.setVisible(true);
    }
}
