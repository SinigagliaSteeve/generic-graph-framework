package core;

import core.node.UndirectedNode;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Alexis on 19/01/2017.
 */
public class IncidentMatrixUndirectedGraph implements IUndirectedGraph {
    @Override
    public int getNbNodes() {
        return 0;
    }

    @Override
    public int[][] toAdjacencyMatrix() {
        return new int[0][];
    }

    @Override
    public int getNbEdges() {
        return 0;
    }

    @Override
    public boolean isEdge(int x, int y) {
        return false;
    }

    @Override
    public void removeEdge(int x, int y) {

    }

    @Override
    public void addEdge(int x, int y) {

    }

    @Override
    public List<Integer> getNeighbors(int x) {
        return null;
    }

    @Override
    public HashMap<Integer, UndirectedNode> getAdjacencyList() {
        return null;
    }
}
