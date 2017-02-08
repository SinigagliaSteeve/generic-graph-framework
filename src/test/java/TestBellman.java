import core.AdjacencyListDirectedGraph;
import core.AdjacencyListUndirectedGraph;
import tool.ArrayTools;
import tool.GraphTools;

/**
 * Created by Alexis on 08/02/2017.
 */
public class TestBellman {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("----");
        System.out.println("Bellman");
        AdjacencyListDirectedGraph listDirectedGraph = new AdjacencyListDirectedGraph(GraphTools.generateGraphData(6, 4, false));
        GraphTools.showMatrix(listDirectedGraph.toAdjacencyMatrix());
        System.out.println("----");
        GraphTools.showMatrix(listDirectedGraph.setRandomWeights(5, true));
        try {
            ArrayTools.showArray(listDirectedGraph.bellman(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
