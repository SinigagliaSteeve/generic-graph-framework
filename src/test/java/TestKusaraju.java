import core.AdjacencyListDirectedGraph;
import core.IDirectedGraph;
import core.algo.Kusaraju;
import tool.GraphTools;

/**
 * Created by Alexis on 09/02/2017.
 */
public class TestKusaraju {

    public static void main(String[] args) {
        final int[][] generatedMatrix = new int[6][6];
        generatedMatrix[0][1] = 1;
        generatedMatrix[0][2] = 1;
        generatedMatrix[1][3] = 1;
        generatedMatrix[1][4] = 1;
        generatedMatrix[2][5] = 1;

        final int[][] test = new int[4][4];
        test[0][1] = 1;
        test[0][3] = 1;
        test[3][1] = 1;
        test[3][2] = 1;
        test[2][0] = 1;


        System.out.println("Test Kusaraju ");
        AdjacencyListDirectedGraph G = new AdjacencyListDirectedGraph(test);
        IDirectedGraph res = new Kusaraju(G).compute();
        GraphTools.showMatrix(res.toAdjacencyMatrix());
    }
}
