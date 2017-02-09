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
}
