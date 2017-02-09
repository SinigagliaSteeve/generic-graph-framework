package core.algo;

import core.IGraph;
import tool.ArrayTools;

import java.util.LinkedList;

/**
 * Created by Alexis on 09/02/2017.
 */
public class GraphExplorer {

    /**
     * First In First out
     * @param G
     */
    public static void breadthFirstSearch(IGraph G){
        System.out.println("Processing breadth-first search on " + G.getClass().getSimpleName() + "...");
        int[] pred = new int[G.getNbNodes()];
        boolean[] mark = new boolean[G.getNbNodes()];
        for(int i = 0; i < G.getNbNodes(); i++){
            pred[i] = -1;
            mark[i] = false;
        }

        LinkedList<Integer> toVisit = new LinkedList<>();
        toVisit.offer(0);
        mark[0] = true;
        while (!toVisit.isEmpty()) {
            int current = toVisit.poll();
            for(int tmp : G.getSuccessors(current)){
                // Si le noeud n'a pas encore été visité
                if (!mark[tmp]) {
                    toVisit.offer(tmp);
                    pred[tmp] = current;
                    mark[tmp] = true;
                }
            }
        }
        System.out.println("Marked:");
        ArrayTools.showArray(mark);
        ArrayTools.showArrayInLine(pred);
    }

    /**
     * First in Last out
     * @param G
     */
    public static void depthFirstSearch(IGraph G){
        System.out.println("Processing depth-first search on " + G.getClass().getSimpleName() + "...");
        int[] pred = new int[G.getNbNodes()];
        boolean[] mark = new boolean[G.getNbNodes()];
        for(int i = 0; i < G.getNbNodes(); i++){
            pred[i] = -1;
            mark[i] = false;
        }

        LinkedList<Integer> toVisit = new LinkedList<>();
        toVisit.push(0);
        mark[0] = true;
        while (!toVisit.isEmpty()) {
            int current = toVisit.pop();
            for(int tmp : G.getSuccessors(current)){
                // Si le noeud n'a pas encore été visité
                if (!mark[tmp]) {
                    toVisit.push(tmp);
                    pred[tmp] = current;
                    mark[tmp] = true;
                }
            }
        }
        System.out.println("Marked:");
        ArrayTools.showArray(mark);
        ArrayTools.showArrayInLine(pred);
    }
}
