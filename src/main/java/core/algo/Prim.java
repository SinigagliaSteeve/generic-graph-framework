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
        System.out.println("Processing PRIM algorithm on " + G.getClass().getSimpleName() + "...");
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
            int x = minVertex(cost, visited);
            visited[x] = true;

            List<Integer> successors = G.getSuccessors(x);
            for(int j=0; j<successors.size(); j++){
                int succ = successors.get(j);
                int w = G.getWeight(x, succ);
                if(cost[succ] > w){
                    cost[succ] = w;
                    pred[succ] = x;
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
