package core;

import core.node.DirectedNode;
import tool.ArrayTools;

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

    default int[] bellman(int s) throws Exception {
        int[] dist = new int[this.getNbNodes()];
        int[] pred = new int[this.getNbNodes()];
        for(int i = 0; i < this.getNbNodes(); i++){
            dist[i] = Integer.MAX_VALUE;
            pred[i] = 0;
        }
        dist[s] = 0;
        for(int k = 0; k < this.getNbNodes() - 1; k++) {
            for(int x = 0; x < this.getNbNodes(); x++) {
                for(int y : this.getSuccessors(x)) {
                    if(dist[y] > dist[x] + this.getWeight(x, y)) {
                        dist[y] = dist[x] + this.getWeight(x, y);
                        pred[y] = x;
                    }
                }
            }
        }

        for (int v = 0; v < this.getNbNodes(); v++) {
            for (int succ : this.getSuccessors(v)) {
                if (dist[succ] > dist[v] + this.getWeight(v, succ))
                    throw new Exception("Negative cycle found");
            }
        }
        return dist;
    }
}
