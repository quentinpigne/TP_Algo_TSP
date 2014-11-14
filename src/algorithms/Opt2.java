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
        Stack<Integer> newStack = new Stack<Integer>();
        for (int i = 0; i < numberOfVertex; i++) {
           newStack = glouton.solution(i);
            if(cost(newStack) < cost(stack)){
                stack = newStack;
            }
        }
    }
    public void solution(){

        boolean better = true;
        while(better){
            better = false;
            double bestDistance = cost(stack);
            for (int i = 1; i < stack.size() - 1; i++) {
                for (int j = 1; j < stack.size() - 1; j++) {
                    if ( (j != i-1) && (i != j) && (j != i+1 )) {
                        Stack<Integer> newStack = swap(stack,i,j);
                        double newDistance = cost(newStack);

                        if (newDistance > bestDistance) {
                            stack = newStack;
                            better = true;
                        }
                    }
                }
            }
        }
    }

    public Stack<Integer> getStack() {
        return stack;
    }

    public Stack<Integer> swap(Stack<Integer> stack, Integer i, Integer j) {
        Stack<Integer> newStack = new Stack<Integer>();
        if (i > j){
            int tmp = i;
            i = j;
            j = tmp;
        }
        for (int k = 0; k <= i-1; k++) {
            newStack.push(stack.elementAt(k));
        }
        for (int k = i; k <= j; k++) {
            newStack.push(stack.elementAt(j + i -k));
        }
        for (int k = j+1; k < stack.size(); k++) {
            newStack.push(stack.elementAt(k));
        }
        return  newStack;
    }
    public double cost(Stack<Integer> stack){
        double d = 0.0;
        for (int i = 0; i < stack.size()  ; i++) {
            d += distanceMatrix[stack.elementAt(i % (numberOfVertex) )][stack.elementAt((i+1) % numberOfVertex )];
        }
        return d;
    }

}
