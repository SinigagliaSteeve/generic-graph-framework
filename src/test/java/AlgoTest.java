package test;

import core.AdjacencyListDirectedGraph;
import core.AdjacencyListUndirectedGraph;
import tool.GraphTools;

/**
 * Created by Alexis on 26/01/2017.
 */
public class AlgoTest {

    public static void main(String[] args) {

        System.out.println("=================================");
        AdjacencyListUndirectedGraph listUndirectedGraph = new AdjacencyListUndirectedGraph(GraphTools.generateGraphData(6, 6, true));
        GraphTools.showMatrix(listUndirectedGraph.toAdjacencyMatrix());
        listUndirectedGraph.breadthFirstSearch();
        listUndirectedGraph.depthFirstSearch();
        System.out.println("----");
        AdjacencyListDirectedGraph listDirectedGraph = new AdjacencyListDirectedGraph(GraphTools.generateGraphData(6, 6, false));
        GraphTools.showMatrix(listDirectedGraph.toAdjacencyMatrix());
        listDirectedGraph.breadthFirstSearch();
        listDirectedGraph.depthFirstSearch();

    }
}
