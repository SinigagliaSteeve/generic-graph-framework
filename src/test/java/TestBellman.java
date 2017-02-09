import core.AdjacencyListDirectedGraph;
import core.AdjacencyListUndirectedGraph;
import core.algo.Bellman;
import tool.ArrayTools;
import tool.GraphTools;

import java.util.HashMap;

/**
 * Created by Alexis on 08/02/2017.
 */
public class TestBellman {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("----");
        System.out.println("Bellman");
//        AdjacencyListDirectedGraph listDirectedGraph = new AdjacencyListDirectedGraph(GraphTools.generateGraphData(6, 4, false));

        AdjacencyListDirectedGraph listDirectedGraph1 = new AdjacencyListDirectedGraph(
                new int[][]{
                        {0, 1, 1, 0, 0, 0},
                        {0, 0, 1, 1, 1, 0},
                        {0, 0, 0, 1, 0, 0},
                        {0, 1, 0, 0, 0, 1},
                        {0, 0, 0, 1, 0, 1},
                        {0, 0, 0, 0, 0, 0}
                }
        );

        int[][] weightMatrix = new int[][]{
                {0, 3, 4, 0, 0, 0},
                {0, 0, 9, 2, 2, 0},
                {0, 0, 0, -5, 0, 0},
                {0, -2, 0, 0, 0, 3},
                {0, 0, 0, 3, 0, 1},
                {0, 0, 0, 0, 0, 0}

        };
        listDirectedGraph1.setWeightAdjacencyMatrix(weightMatrix);

//        GraphTools.showMatrix(listDirectedGraph1.toAdjacencyMatrix());
        boolean noExc = false;
        while (!noExc) {
            System.out.println("----");
//            GraphTools.showMatrix(listDirectedGraph1.setRandomWeights(5, true));
            try {
                ArrayTools.showArray(Bellman.compute(listDirectedGraph1,0));
//                ArrayTools.showArray(listDirectedGraph1.bellman(0));
//                System.out.println("------------");
//                ArrayTools.showMap(listDirectedGraph1.bellmanv2(0));
                noExc = true;
            } catch (Exception e) {
                System.out.println("Regenerate random weights");
            }
        }

    }

}
