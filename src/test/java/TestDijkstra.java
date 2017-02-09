import core.AdjacencyListDirectedGraph;
import core.IDirectedGraph;
import core.algo.Dijkstra;
import core.algo.Kosaraju;
import tool.GraphTools;

/**
 * Created by Alexis on 09/02/2017.
 */
public class TestDijkstra {

    public static void main(String[] args) {
        final int[][] matrix = new int[5][5];
        matrix[0][1] = 1;
        matrix[0][3] = 1;
        matrix[1][2] = 1;
        matrix[2][3] = 1;
        matrix[2][4] = 1;
        matrix[3][1] = 1;
        matrix[3][4] = 1;
        final int[][] weightMatrix = new int[5][5];
        weightMatrix[0][1] = 1;
        weightMatrix[0][3] = 5;
        weightMatrix[1][2] = 3;
        weightMatrix[2][3] = 0;
        weightMatrix[2][4] = 2;
        weightMatrix[3][1] = 1;
        weightMatrix[3][4] = 1;

        System.out.println("Test Dijkstra");
        AdjacencyListDirectedGraph G = new AdjacencyListDirectedGraph(matrix);
        GraphTools.showMatrix(G.toAdjacencyMatrix());
        System.out.println("---");
        G.setWeightAdjacencyMatrix(weightMatrix);
        GraphTools.showMatrix(G.toWeightAdjacencyMatrix());
        Dijkstra.compute(G, 0);
    }

}
