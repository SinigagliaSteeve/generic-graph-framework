import core.AdjacencyListDirectedGraph;
import core.AdjacencyListUndirectedGraph;
import tool.GraphTools;

/**
 * Created by Alexis on 08/02/2017.
 */
public class TestAdjacencyListDirectedGraph {
    public static void main(String[] args) {
        System.out.println("===============================");
        System.out.println("TEST AdjacencyListDirectedGraph");
        AdjacencyListDirectedGraph listDirectedGraph = new AdjacencyListDirectedGraph(GraphTools.generateGraphData(4, 3, true));
        GraphTools.showMatrix(listDirectedGraph.toAdjacencyMatrix());

        System.out.println("nbArcs() ...");
        System.out.println(listDirectedGraph.getNbArcs());

        System.out.println("isArc() 0,1 ...");
        boolean isArc = listDirectedGraph.isArc(0, 1);
        System.out.println(isArc);

        if (isArc) {
            System.out.println("removeArc() 0,1 ...");
            listDirectedGraph.removeArc(0, 1);
            System.out.println(!listDirectedGraph.isArc(0, 1));
        } else {
            System.out.println("addArc() 0,1 ...");
            listDirectedGraph.addArc(0, 1);
            System.out.println(listDirectedGraph.isArc(0, 1));
        }

        System.out.println("getSuccessors() 0");
        System.out.println(listDirectedGraph.getSuccessors(0));

        System.out.println("getPredecessors() 0");
        System.out.println(listDirectedGraph.getPredecessors(0));

        System.out.println("nbNodes() ...");
        System.out.println(listDirectedGraph.getNbNodes());

        System.out.println("toAdjacencyMatrix() ...");
        GraphTools.showMatrix(listDirectedGraph.toAdjacencyMatrix());

        System.out.println("computeInverse() ...");
        GraphTools.showMatrix(listDirectedGraph.computeInverse().toAdjacencyMatrix());

        System.out.println("generate random weights() ...");
        GraphTools.showMatrix(listDirectedGraph.setRandomWeights(5, false));
    }
}
