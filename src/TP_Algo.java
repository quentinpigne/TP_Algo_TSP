import graph.BoundaryException;
import algorithms.Glouton;
import graph.Graph;
import graph.GraphGenerator;
import gui.GraphGUI;

import javax.swing.*;
import java.util.Stack;

public class TP_Algo {
    public static void main(String[] args) {
        Graph graphe = null;
        try {
            graphe = GraphGenerator.generate(6, 0.1);
        } catch (BoundaryException e) {

        }

        GraphGUI graphGUI = new GraphGUI(graphe.getV(), graphe.getE());
        graphGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graphGUI.setSize(750, 750);
        graphGUI.setVisible(true);

        Glouton glouton = new Glouton(graphe);
        Stack<Integer> stack = new Stack<Integer>();
        stack = glouton.solution(4);
//        for (int i = 0; i < stack.size(); i++) {
//            System.out.println(stack.elementAt(i));
//        }
        double d = glouton.cost();
        //System.out.println(d);

    }
}
