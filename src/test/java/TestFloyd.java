import core.AdjacencyListDirectedGraph;
import core.algo.Floyd;
import tool.ArrayTools;
import tool.GraphTools;

/**
 * Created by Steeve Sinigaglia on 10/02/2017.
 */
public class TestFloyd {
    private final static boolean DISPLAY = false;

    public static void main(String[] args) {
        int matrix[][] = new int[][]{
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };

        AdjacencyListDirectedGraph graph = new AdjacencyListDirectedGraph(matrix);

        // Modification des poids
        graph.setWeightAdjacencyMatrix(
                new int[][]{
                        {0, 1, 0, 5, 0},
                        {0, 0, 3, 0, 0},
                        {0, 0, 0, 0, 2},
                        {0, 1, 0, 0, 1},
                        {0, 0, 0, 0, 0}
                }
        );

        Object[] result = Floyd.compute(graph);
        int[][] distances = (int[][]) result[0];
        int[][] successors = (int[][]) result[1];

        GraphTools.showMatrix(matrix);
        final int x = 3;
        final int y = 2;
        System.out.println("Chemin le plus court entre le noeud " + x + " et " + y + " est " + ArrayTools.arrayToString(Floyd.getPathFromFloydSuccessorsMatrix(successors, x, y)) + " avec une distance de " + distances[x][y]);
    }
}

