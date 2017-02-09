package core.algo;

import core.IGraph;
import core.IUndirectedGraph;
import tool.ArrayTools;

import java.util.List;

/**
 * Created by Alexis on 09/02/2017.
 */
public class Prim {

    public static void prim (IUndirectedGraph G, int s) {
        System.out.println("Processing prim algorithm on " + G.getClass().getSimpleName() + "...");
        int[] cost = new int[G.getNbNodes()];
        int[] pred = new int[G.getNbNodes()];
        boolean[] visited = new boolean[G.getNbNodes()];
        for(int i = 0; i < G.getNbNodes(); i++){
            cost[i] = Integer.MAX_VALUE;
            pred[i] = -1;
            visited[i] = false;
        }
        cost[s] = 0;
        for (int i=0; i < cost.length; i++) {
            int next = minVertex(cost, visited);
            visited[next] = true;

            List<Integer> n = G.getSuccessors(next);
            for(int j=0; j<n.size(); j++){
                int v = n.get(j);
                int d = G.getWeight(next, v);
                if(cost[v] > d){
                    cost[v] = d;
                    pred[v] = next;
                }
            }
        }
        ArrayTools.showArrayInLine(pred);
    }

    private static int minVertex (int [] dist, boolean [] v) {
        int x = Integer.MAX_VALUE;
        int y = -1;   // graph not connected, or no unvisited vertices
        for (int i=0; i<dist.length; i++) {
             if (!v[i] && dist[i]<x) {
                 y=i;
                 x=dist[i];
             }
        }
          return y;
    }
}
