package core.algo;

import core.IDirectedGraph;
import core.node.Edge;
import tool.GraphTools;

/**
 * Created by Steeve Sinigaglia on 09/02/2017.
 */
public class Bellman {
    
    public static int[] compute (IDirectedGraph G, int startNode) throws Exception {
        int[] dist = new int[G.getNbNodes()];
        int[] pred = new int[G.getNbNodes()];
        for (int i = 0; i < G.getNbNodes(); i++) {
            dist[i] = Integer.MAX_VALUE;
            pred[i] = 0;
        }

        dist[startNode] = 0;
        for (int k = 1; k < G.getNbNodes() - 1; k++) {
            for (Edge edge : G.getEdges()) {
                dist[edge.to] = GraphTools.getMinBetween(dist[edge.to],
                        dist[edge.from] + G.getWeight(edge.from, edge.to));
            }
        }

        for (int v = 0; v < G.getNbNodes(); v++) {
            for (int succ : G.getSuccessors(v)) {
                if (dist[succ] > dist[v] + G.getWeight(v, succ))
                    throw new Exception("Negative cycle found");
            }
        }


        return dist;
    }
}
