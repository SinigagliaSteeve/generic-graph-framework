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

    default int[] bellman(int s) throws Exception {
        int[] dist = new int[this.getNbNodes()];
        int[] prev = new int[this.getNbNodes()];
        for(int i = 0; i < this.getNbNodes(); i++){
            dist[i] = Integer.MAX_VALUE;
            prev[i] = 0;
        }
        dist[s] = 0;
        for(int i = 0; i < this.getNbNodes() - 1; i++){
            for (int v = 0; v < this.getNbNodes(); v++) {
                for (int succ : this.getSuccessors(v)) {
                    if (dist[succ] > dist[v] + this.getWeight(v, succ))
                        dist[succ] = dist[v] + this.getWeight(v, succ);
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
