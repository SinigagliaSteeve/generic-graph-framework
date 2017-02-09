import core.AdjacencyListUndirectedGraph;
import core.algo.Prim;
import tool.GraphTools;

/**
 * Created by Alexis on 09/02/2017.
 */
public class Test {

    public static void main(String[] args) {

        System.out.println("=================================");
        final int[][] matrix = new int[3][3];
        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[1][0] = 1;
        matrix[1][2] = 1;
        matrix[2][0] = 1;
        matrix[2][1] = 1;

        final int[][] weightMatrix = new int[3][3];
        weightMatrix[0][1] = 5;
        weightMatrix[0][2] = 7;
        weightMatrix[1][0] = 5;
        weightMatrix[1][2] = 3;
        weightMatrix[2][0] = 7;
        weightMatrix[2][1] = 3;

        AdjacencyListUndirectedGraph G = new AdjacencyListUndirectedGraph(matrix);
        GraphTools.showMatrix(G.toAdjacencyMatrix());
        System.out.println("---");
        G.setWeightAdjacencyMatrix(weightMatrix);
        GraphTools.showMatrix(G.toWeightAdjacencyMatrix());
        Prim.prim(G, 0);

    }

}
