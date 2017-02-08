package core;

import tool.ArrayTools;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alexis on 13/01/2017.
 */
public interface IGraph {
    int getNbNodes();
    int[][] toAdjacencyMatrix();
    List<Integer> getSuccessors(int x);
    List<Integer> getPredecessors(int x);

    default int getWeight(int x, int y){
        return 0;
    }

    default void breadthFirstSearch(){
        System.out.println("Processing breadth-first search on " + this.getClass().getSimpleName() + "...");
        boolean[] mark = new boolean[this.getNbNodes()];
        LinkedList<Integer> toVisit = new LinkedList<>();
        toVisit.offer(0);
        mark[0] = true;
        while (!toVisit.isEmpty()) {
            int current = toVisit.poll();
            for(int tmp : this.getSuccessors(current)){
                // Si le noeud n'a pas encore été visité
                if (!mark[tmp]) {
                    toVisit.offer(tmp);
                    mark[tmp] = true;
                }
            }
        }
        System.out.println("Marked:");
        ArrayTools.showArray(mark);
    }

    default void depthFirstSearch(){
        System.out.println("Processing depth-first search on " + this.getClass().getSimpleName() + "...");
        boolean[] mark = new boolean[this.getNbNodes()];
        LinkedList<Integer> toVisit = new LinkedList<>();
        toVisit.push(0);
        mark[0] = true;
        while (!toVisit.isEmpty()) {
            int current = toVisit.pop();
            for(int tmp : this.getSuccessors(current)){
                // Si le noeud n'a pas encore été visité
                if (!mark[tmp]) {
                    toVisit.push(tmp);
                    mark[tmp] = true;
                }
            }
        }
        System.out.println("Marked:");
        ArrayTools.showArray(mark);
    }
}
