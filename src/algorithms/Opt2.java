package algorithms;

import graph.Graph;

import java.util.Stack;

/**
 * Created by amadou on 13/11/14.
 */
public class Opt2 {
    private int numberOfVertex;
    private double[][] distanceMatrix;
    private Stack<Integer> stack;

    public Opt2(Graph graph){
    Glouton glouton = new Glouton(graph);
        numberOfVertex = glouton.getNumberOfVertex();
        distanceMatrix = glouton.getDistanceMatrix();
        int first = 0;
        stack = glouton.solution(first);
    }

}
