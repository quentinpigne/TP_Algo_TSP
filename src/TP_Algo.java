import algorithms.Enumeration;
import graph.BoundaryException;
import graph.Graph;
import graph.GraphGenerator;
import gui.GraphGUI;

import javax.swing.*;
import java.util.Stack;

public class TP_Algo {
    public static void main(String[] args) {
        long times[] = new long[10];
        for (int i = 1; i <= 10; i++) {
            Graph graphe = null;
            try {
                graphe = GraphGenerator.generate(i, 0.2);
            } catch (BoundaryException e) {}
            long timeBefore = System.currentTimeMillis();
            Enumeration enumeration = new Enumeration(graphe);
            enumeration.solution();
            long timeAfter = System.currentTimeMillis();
            long timeExec = timeAfter - timeBefore;
            times[i-1] = timeExec;
        }

        //Affichage des temps
        for (int i = 1; i <= 10; i++) {
            System.out.println("Graphe avec " + i + " sommet(s) -> " + times[i-1] + " ms.");
        }

//        GraphGUI graphGUI = new GraphGUI(graphe.getV(), graphe.getE());
//        graphGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        graphGUI.setSize(750, 750);
//        graphGUI.setVisible(true);
    }
}
