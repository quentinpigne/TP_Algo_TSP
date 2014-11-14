package algorithms;

import graph.Graph;

import java.util.Stack;

public class ProgDyn {
    private Stack<Integer> stack;
    private int numberOfVertex;
    private double[][] distanceMatrix;

    public Stack<Integer> getStacks() {
        return stack;
    }

    public int getNumberOfVertex() {
        return numberOfVertex;
    }

    public double[][] getDistanceMatrix() {
        return distanceMatrix;
    }

    public ProgDyn(Graph graph){
        stack = new Stack<Integer>();
        numberOfVertex = graph.getV().size();
        distanceMatrix = graph.getDistanceMatrix();
    }

    //C(S, n) = min C(S\{n}, i) + l(i,n)
    public Stack<Integer> solution() {
        //Remplissage de la stack avec les sommets
        for (int i = 0; i < numberOfVertex; i++) {
            stack.push(i);
        }

        for (int j = 1; j < numberOfVertex; j++) {
            for (int i = 0; i < stack.size(); i++) {

            }
        }
        return stack;
    }
}
