package algorithms;

import graph.Graph;

import java.util.Stack;

/**
 * Created by amadou on 12/11/14.
 */
public class Glouton {
    // pour stocker les sommets parcourus
    private Stack <Integer> stack;
    private int numberOfVertex;
    private double[][] distanceMatrix;

    public Stack<Integer> getStack() {
        return stack;
    }

    public int getNumberOfVertex() {
        return numberOfVertex;
    }

    public double[][] getDistanceMatrix() {
        return distanceMatrix;
    }

    public Glouton(Graph graph){
        stack = new Stack<Integer>();
        numberOfVertex = graph.getV().size();
        distanceMatrix = graph.getDistanceMatrix();
    }

    public Stack<Integer> solution(int first){
        int[] visited = new int[numberOfVertex + 1];
        // On place le premier sommet dans notre pile
        visited[first] = 1;
        stack.push(first);

        int source, destination = -1,i;
        while (stack.size() != numberOfVertex){
            source =  stack.peek();
            i = 0;
            double min = Integer.MAX_VALUE;
                while (i < numberOfVertex){
                    if (visited[i] == 0){
                        if (min > distanceMatrix[source][i]){
                            min = distanceMatrix[source][i];
                            destination = i;
                        }
                    }
                    i++;
                }
                visited[destination] = 1;
                stack.push(destination);
        }
        return stack;
    }

    public double cost(){
        double d = 0.0;
        for (int i = 0; i < stack.size()  ; i++) {
            d += distanceMatrix[stack.elementAt(i % (numberOfVertex) )][stack.elementAt((i+1) % numberOfVertex )];
        }
        return d;
    }
}
