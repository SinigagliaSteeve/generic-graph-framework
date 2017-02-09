package test;

import core.AdjacencyListDirectedGraph;
import core.AdjacencyListUndirectedGraph;
import core.AdjacencyMatrixUndirectedGraph;
import tool.GraphTools;

/**
 * Created by Alexis on 13/01/2017.
 */
public class TestGraph {

    public static void main(String[] args){

        System.out.println("=================================");
        System.out.println("TEST AdjacencyListUndirectedGraph");
        AdjacencyListUndirectedGraph listUndirectedGraph = new AdjacencyListUndirectedGraph(GraphTools.generateGraphData(4, 3, true));
        GraphTools.showMatrix(listUndirectedGraph.toAdjacencyMatrix());

        System.out.println("nbEdges() ...");
        System.out.println(listUndirectedGraph.getNbEdges());

        System.out.println("isEdge() 0,1 ...");
        boolean isEdge = listUndirectedGraph.isEdge(0, 1);
        System.out.println(isEdge);

        if(isEdge) {
            System.out.println("removeEdge() 0,1 ...");
            listUndirectedGraph.removeEdge(0, 1);
            System.out.println(!listUndirectedGraph.isEdge(0, 1));
        } else {
            System.out.println("addEdge() 0,1 ...");
            listUndirectedGraph.addEdge(0, 1);
            System.out.println(listUndirectedGraph.isEdge(0, 1));
        }

        System.out.println("getNeighbors() 0");
        System.out.println(listUndirectedGraph.getNeighbors(0));

        System.out.println("nbNodes() ...");
        System.out.println(listUndirectedGraph.getNbNodes());

        System.out.println("toAdjacencyMatrix() ...");
        GraphTools.showMatrix(listUndirectedGraph.toAdjacencyMatrix());




        System.out.println("===============================");
        System.out.println("TEST AdjacencyListDirectedGraph");
        AdjacencyListDirectedGraph listDirectedGraph = new AdjacencyListDirectedGraph(GraphTools.generateGraphData(4, 3, true));
        GraphTools.showMatrix(listDirectedGraph.toAdjacencyMatrix());

        System.out.println("nbArcs() ...");
        System.out.println(listDirectedGraph.getNbArcs());

        System.out.println("isArc() 0,1 ...");
        boolean isArc = listDirectedGraph.isArc(0, 1);
        System.out.println(isArc);

        if(isArc) {
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




        System.out.println("=================================");
        System.out.println("TEST AdjacencyMatrixUndirectedGraph");
        AdjacencyMatrixUndirectedGraph matrixUndirectedGraph = new AdjacencyMatrixUndirectedGraph(GraphTools.generateGraphData(4, 3, true));
        GraphTools.showMatrix(matrixUndirectedGraph.toAdjacencyMatrix());

        System.out.println("nbEdges() ...");
        System.out.println(matrixUndirectedGraph.getNbEdges());

        System.out.println("isEdge() 0,1 ...");
        isEdge = matrixUndirectedGraph.isEdge(0, 1);
        System.out.println(isEdge);

        if(isEdge) {
            System.out.println("removeEdge() 0,1 ...");
            matrixUndirectedGraph.removeEdge(0, 1);
            System.out.println(!matrixUndirectedGraph.isEdge(0, 1));
        } else {
            System.out.println("addEdge() 0,1 ...");
            matrixUndirectedGraph.addEdge(0, 1);
            System.out.println(matrixUndirectedGraph.isEdge(0, 1));
        }

        System.out.println("getNeighbors() 0");
        System.out.println(matrixUndirectedGraph.getNeighbors(0));

        System.out.println("nbNodes() ...");
        System.out.println(matrixUndirectedGraph.getNbNodes());

        System.out.println("toAdjacencyMatrix() ...");
        GraphTools.showMatrix(matrixUndirectedGraph.toAdjacencyMatrix());
    }
}
