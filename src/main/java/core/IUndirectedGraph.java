package core;

import core.node.UndirectedNode;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Alexis on 13/01/2017.
 */
public interface IUndirectedGraph extends IGraph{
    int getNbEdges();
    boolean isEdge(int x, int y);
    void removeEdge(int x, int y);
    void addEdge(int x, int y);
    List<Integer> getNeighbors(int x);
    HashMap<Integer, UndirectedNode> getAdjacencyList();

    @Override
    default List<Integer> getSuccessors(int x) {
        return this.getNeighbors(x);
    }

    @Override
    default List<Integer> getPredecessors(int x) {
        return this.getNeighbors(x);
    }
}
