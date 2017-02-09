package core.algo;

import core.AdjacencyListDirectedGraph;
import core.IDirectedGraph;

import java.util.Arrays;

/**
 * Computes Strong Connected Components from a Undirected Graph with the Kurasaju algorithm.
 * Created by Alexis on 09/02/2017.
 */
public class Kusaraju {
    private IDirectedGraph graphToExplore;
    private IDirectedGraph inductedGraph;
    private boolean[] mark;
    private int cpt = 0;
    private int[] begin;
    private int[] end;

    public Kusaraju(IDirectedGraph G){
        this.graphToExplore = G;
        int[][] matrix = new int[G.getNbNodes()][G.getNbNodes()];
        inductedGraph = new AdjacencyListDirectedGraph(matrix);
        cpt = 0;
        begin = new int[G.getNbNodes()];
        end = new int[G.getNbNodes()];
        mark = new boolean[G.getNbNodes()];
    }

    public IDirectedGraph compute() {

        // Explore a first time
        for (int i = 0; i < graphToExplore.getNbNodes(); i++) {
            if(!mark[i])
                exploreDepthDirectedGraph(i);
        }

        // Inversedgraph and reset mark
        graphToExplore = graphToExplore.computeInverse();
        int[][] matrix = new int[graphToExplore.getNbNodes()][graphToExplore.getNbNodes()];
        inductedGraph = new AdjacencyListDirectedGraph(matrix);
        Arrays.fill(mark,false);

        // Explore a second time
        for (int i = 0; i < graphToExplore.getNbNodes(); i++) {
            // Gets max end not explored yet
            int max = getMaxEndNotExplored();
//            if(!mark[i]){
            exploreDepthDirectedGraph(max);
//            }
        }

        return this.inductedGraph;

    }

    /**
     * Recursive DFS with time saving.
     * @param i
     */
    private void exploreDepthDirectedGraph(int i) {
        mark[i] = true;
        begin[i] = ++cpt;
        for(int successor : graphToExplore.getSuccessors(i)){
            if(!mark[successor]){
                inductedGraph.addArc(i,successor);
                exploreDepthDirectedGraph(successor);
            }
        }
        end[i] = ++cpt;
    }

    /**
     * Retrive max ended vertex.
     * @return vertex's number.
     */
    private int getMaxEndNotExplored() {
        int max = 0;
        for(int n = 0; n < end.length ; n++){
            if(!mark[n]){
                max = n;
                break;
            }
        }
        for (int n = 0; n < end.length; n++) {
            if (end[n] > end[max] && !mark[n]) {
                max = n;
            }
        }
        return max;
    }
}
