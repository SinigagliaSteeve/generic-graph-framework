import core.AdjacencyListDirectedGraph;
import core.AdjacencyListUndirectedGraph;
import core.algo.Prim;
import tool.ArrayTools;
import tool.GraphTools;

/**
 * Created by Alexis on 09/02/2017.
 */
public class TestPrim {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("----");
        System.out.println("PRIM");
        AdjacencyListUndirectedGraph listUndirectedGraph = new AdjacencyListUndirectedGraph(GraphTools.generateGraphData(6, 4, true));
        GraphTools.showMatrix(listUndirectedGraph.toAdjacencyMatrix());
        System.out.println("----");
        GraphTools.showMatrix(listUndirectedGraph.setRandomWeights(5, true));
        Prim.prim(listUndirectedGraph, 0);

    }
}
