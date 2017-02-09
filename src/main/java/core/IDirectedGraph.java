package core;

import core.node.DirectedNode;
import core.node.Edge;
import javafx.util.Pair;
import sun.reflect.generics.tree.Tree;
import tool.ArrayTools;
import tool.GraphTools;

import java.util.*;

/**
 * Created by Alexis on 13/01/2017.
 */
public interface IDirectedGraph extends IGraph {
    int getNbArcs();

    boolean isArc(int from, int to);

    void removeArc(int from, int to);

    void addArc(int from, int to);

    IDirectedGraph computeInverse();

    HashMap<Integer, DirectedNode> getAdjacencyList();

    int[][] getWeightAdjacencyMatrix();

    void setWeightAdjacencyMatrix(int[][] matrix);

    List<Edge> getEdges();

    default LinkedHashMap<Integer, Integer> bellmanv2(int s) throws Exception {
        LinkedHashMap<Integer, Integer> dists = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> preds = new LinkedHashMap<>();

        dists.put(s, 0);
        preds.put(s, 0);

        for (int i = 0; i < this.getNbNodes(); i++) {
            if (i != s) {
                dists.put(i, Integer.MAX_VALUE);
                preds.put(i, 0);
            }
        }

        for (int k = 1; k < this.getNbNodes() - 1; k++) {
            for (Edge edge : this.getEdges()) {
                dists.put(edge.to, GraphTools.getMinBetween(dists.get(edge.to),
                        dists.get(edge.from) + this.getWeight(edge.from, edge.to)));
            }
        }


        for (Edge edge : this.getEdges()) {
            if ((dists.get(edge.from) + this.getWeight(edge.from,edge.to)) < dists.get(edge.to)){
                throw new Exception("Negative cycle found");
            }
        }

        return dists;
    }

    default int[] bellman(int s) throws Exception {


        int[] dist = new int[this.getNbNodes()];
        int[] pred = new int[this.getNbNodes()];
        for (int i = 0; i < this.getNbNodes(); i++) {
            dist[i] = Integer.MAX_VALUE;
            pred[i] = 0;
        }

        dist[s] = 0;
        for (int k = 1; k < this.getNbNodes() - 1; k++) {
            for (Edge edge : this.getEdges()) {
                dist[edge.to] = GraphTools.getMinBetween(dist[edge.to],
                        dist[edge.from] + this.getWeight(edge.from, edge.to));
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
