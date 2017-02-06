package core;

import core.node.DirectedNode;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Alexis on 13/01/2017.
 */
public interface IDirectedGraph extends IGraph{
    int getNbArcs();
    boolean isArc(int from, int to);
    void removeArc(int from, int to);
    void addArc(int from, int to);
    IDirectedGraph computeInverse();
    HashMap<Integer, DirectedNode> getAdjacencyList();

    default int[] bellman(){
        // TODO: 06/02/2017
        return null;
    }
}
