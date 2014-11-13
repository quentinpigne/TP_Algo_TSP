package algorithms;

import graph.Edge;
import graph.Graph;
import graph.Path;
import graph.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Idée de l'algo :
- Trouver les n combinaisons de n parmis n sommets
- Créer une liste de n! chemins
- Remplir les chemins avec les arcs -> calcul des longueurs
- Trouver le chemin de longueur minimale
 */

public class Enumeration {
    // pour stocker les sommets parcourus
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

    public Enumeration(Graph graph){
        stack = new Stack<Integer>();
        numberOfVertex = graph.getV().size();
        distanceMatrix = graph.getDistanceMatrix();
    }

    public Stack<Integer> solution() {
        List<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
        for (int i = 0; i < factorielle(numberOfVertex); i++) {
            stacks.add(new Stack<Integer>());
        }

        //Création d'une liste de liste de sommets
        int vertexTab[] = new int[numberOfVertex];
        for (int i = 0; i < vertexTab.length; i++) {
            vertexTab[i] = i;
        }

        //Recherche des n combinaisons de n parmis n sommets
        ArrayList<ArrayList<Integer>> combi = permute(vertexTab);

        //Création de la liste des n! stacks
        for (int i = 0; i < factorielle(numberOfVertex); i++) {
            for (int j = 0; j < numberOfVertex; j++) {
                stacks.get(i).push(combi.get(i).get(j));
            }
        }

        //Recherche du plus court chemin parmis tous ceux calculés
        stack = stacks.get(0);
        for(Stack<Integer> st : stacks) {
            if(cost(st) < cost(stack)) stack = st;
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

    private double cost(Stack<Integer> s){
        double d = 0.0;
        for (int i = 0; i < stack.size()  ; i++) {
            d += distanceMatrix[s.elementAt(i % (numberOfVertex) )][s.elementAt((i+1) % numberOfVertex )];
        }
        return d;
    }

    private int factorielle(int n)
    {
        if(n>1)
            return n*factorielle(n - 1);
        else
            return 1;
    }

    private ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        //start from an empty list
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size()+1; j++) {
                    // + add num[i] to different locations
                    l.add(j, num[i]);

                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);

                    //System.out.println(temp);

                    // - remove num[i] add
                    l.remove(j);
                }
            }

            result = new ArrayList<ArrayList<Integer>>(current);
        }

        return result;
    }
}
