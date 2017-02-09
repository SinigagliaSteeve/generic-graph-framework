package core.algo;

import core.IDirectedGraph;

import java.util.Arrays;

/**
 * Created by Steeve Sinigaglia on 10/02/2017.
 */
public class Floyd {
    public static Object[] compute(IDirectedGraph graph) {
        int distances[][] = graph.getWeightAdjacencyMatrix();
        int successors[][] = new int[graph.getNbNodes()][graph.getNbNodes()];

        for (int x = 0; x < graph.getNbNodes(); x++) {
            for (int y = 0; y < graph.getNbNodes(); y++) {
                successors[x][y] = y;
            }
        }

        for (int k = 0; k < graph.getNbNodes(); k++) {
            for (int i = 0; i < graph.getNbNodes(); i++) {
                for (int j = 0; j < graph.getNbNodes(); j++) {
                    if (distances[i][k] != Integer.MAX_VALUE && distances[k][j] != Integer.MAX_VALUE && distances[i][k] + distances[k][j] < distances[i][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                        successors[i][j] = successors[i][k];
                    }
                }
            }
        }

        return new Object[]{distances, successors};
    }

    public static int[] getPathFromFloydSuccessorsMatrix(int[][] successors, int x, int y) {
        if (successors[x][y] == 0) {
            return null;
        }

        int[] path = new int[successors.length];
        path[0] = x;

        int i = 1;
        while (x != y) {
            x = successors[x][y];
            path[i] = x;
            i++;
        }

        return Arrays.copyOf(path, i);
    }
}
