package core.algo;

import core.IDirectedGraph;
import tool.ArrayTools;

import java.util.Arrays;

/**
 * Created by Alexis on 09/02/2017.
 */
public class Dijkstra {

    public static void compute(IDirectedGraph G, int firstNode) {
        System.out.println("Processing Dijkstra algorithm on " + G.getClass().getSimpleName() + "...");
        int[] dist = new int[G.getNbNodes()];
        int[] pred = new int[G.getNbNodes()];
        boolean[] mark = new boolean[G.getNbNodes()];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(mark, false);
        Arrays.fill(pred, -1);

        dist[firstNode] = 0;

        for (int i = 0; i < G.getNbNodes() - 1; i++) {
            int node = minDistance(dist, mark);

            mark[node] = true;

            for (int j = 0; j < G.getNbNodes(); j++) {
                if (!mark[j] && G.isArc(node, j) && dist[node] != Integer.MAX_VALUE && dist[node] + G.getWeight(node, j) < dist[j]) {
                    dist[j] = dist[node] + G.getWeight(node, j);
                    pred[j] = node;
                }
            }
        }

        System.out.print("marked: "); ArrayTools.showArrayInLine(mark);
        System.out.print("dist: "); ArrayTools.showArrayInLine(dist);
        System.out.print("pred: "); ArrayTools.showArrayInLine(pred);
    }

    public static int minDistance(int distance[], boolean nodeVisited[]) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int n = 0; n < distance.length; n++) {
            if (!nodeVisited[n] && distance[n] <= min) {
                min = distance[n];
                min_index = n;
            }
        }

        return min_index;
    }
}
