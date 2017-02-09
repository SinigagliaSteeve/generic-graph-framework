import core.AdjacencyListDirectedGraph;
import core.IDirectedGraph;
import core.algo.Kosaraju;
import tool.GraphTools;

/**
 * Created by Alexis on 09/02/2017.
 */
public class TestKosaraju {

    public static void main(String[] args) {
        final int[][] test = new int[4][4];
        test[0][1] = 1;
        test[0][3] = 1;
        test[3][1] = 1;
        test[3][2] = 1;
        test[2][0] = 1;

        System.out.println("Test Kosaraju ");
        AdjacencyListDirectedGraph G = new AdjacencyListDirectedGraph(test);
        IDirectedGraph res = new Kosaraju(G).compute();
        GraphTools.showMatrix(res.toAdjacencyMatrix());
    }
}
