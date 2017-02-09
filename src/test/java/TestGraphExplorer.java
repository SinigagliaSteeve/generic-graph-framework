import core.AdjacencyListDirectedGraph;
import core.AdjacencyListUndirectedGraph;
import core.algo.GraphExplorer;
import tool.GraphTools;

/**
 * Created by Alexis on 09/02/2017.
 */
public class TestGraphExplorer {

    public static void main(String[] args) {

        System.out.println("=================================");
        AdjacencyListUndirectedGraph listUndirectedGraph = new AdjacencyListUndirectedGraph(GraphTools.generateGraphData(6, 4, true));
        GraphTools.showMatrix(listUndirectedGraph.toAdjacencyMatrix());
        GraphExplorer.breadthFirstSearch(listUndirectedGraph);
        GraphExplorer.depthFirstSearch(listUndirectedGraph);
        System.out.println("----");
        AdjacencyListDirectedGraph listDirectedGraph = new AdjacencyListDirectedGraph(GraphTools.generateGraphData(6, 4, false));
        GraphTools.showMatrix(listDirectedGraph.toAdjacencyMatrix());
        GraphExplorer.breadthFirstSearch(listDirectedGraph);
        GraphExplorer.depthFirstSearch(listDirectedGraph);

    }

}
