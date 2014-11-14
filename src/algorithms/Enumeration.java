package algorithms;

import graph.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Idée de l'algo :
- Trouver les n combinaisons de n parmis n sommets
- Créer une liste de n! chemins
- Récupérer les longueurs des n! chemins à l'aide de la matrice des distances
- Trouver le chemin de longueur minimale
 */

public class Enumeration {
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
        //On crée la liste qui servira à stocker toutes les combinaisons de chemins possibles
        List<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
        for (int i = 0; i < factorielle(numberOfVertex); i++) {
            stacks.add(new Stack<Integer>());
        }

        //Création du vecteur contenant tous les sommets du graphe
        int vertexTab[] = new int[numberOfVertex];
        for (int i = 0; i < vertexTab.length; i++) {
            vertexTab[i] = i;
        }

        //Recherche des n combinaisons de n parmis n sommets à partir du vecteur des sommets du graphe
        ArrayList<ArrayList<Integer>> combi = permute(vertexTab);

        //Remplissage de la liste des n! chemins possibles
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

    /*
    Fonction renvoyant la longueur du plus petit chemin calculé par l'algorithme
     */
    public double cost(){
        double d = 0.0;
        for (int i = 0; i < stack.size()  ; i++) {
            d += distanceMatrix[stack.elementAt(i % (numberOfVertex) )][stack.elementAt((i+1) % numberOfVertex )];
        }
        return d;
    }

    /*
    Fonction calculant la longueur d'un chemin (un ensemble de sommets).
     */
    private double cost(Stack<Integer> s){
        double d = 0.0;
        for (int i = 0; i < stack.size()  ; i++) {
            d += distanceMatrix[s.elementAt(i % (numberOfVertex) )][s.elementAt((i+1) % numberOfVertex )];
        }
        return d;
    }

    /*
    Fonction renvoyant la factorielle d'un nombre
     */
    private int factorielle(int n)
    {
        if(n>1)
            return n*factorielle(n - 1);
        else
            return 1;
    }

    /*
    Fonction permettant de trouver toutes les permutations possibles de n nombres.
     */
    private ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> l : result) {
                for (int j = 0; j < l.size()+1; j++) {
                    l.add(j, num[i]);
                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);
                    l.remove(j);
                }
            }
            result = new ArrayList<ArrayList<Integer>>(current);
        }
        return result;
    }
}
