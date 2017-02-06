package core;

import core.node.UndirectedNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Alexis on 19/01/2017.
 */
public class AdjacencyMatrixUndirectedGraph implements IUndirectedGraph {

    private int nbNodes;
    private int nbEdges;
    private int[][] adjacencyMatrix;

    public AdjacencyMatrixUndirectedGraph(int[][] matrix){
        this.adjacencyMatrix = matrix;
        this.nbNodes = matrix.length;
        this.nbEdges = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < i; j++) {
                if (matrix[i][j] == 1)
                    this.nbEdges++;
            }
        }
    }

    public AdjacencyMatrixUndirectedGraph(IUndirectedGraph undirectedGraph){
        this.adjacencyMatrix = undirectedGraph.toAdjacencyMatrix().clone();
        this.nbNodes = undirectedGraph.getNbNodes();
        this.nbEdges = undirectedGraph.getNbEdges();
    }

    @Override
    public int getNbNodes() {
        return this.nbNodes;
    }

    @Override
    public int[][] toAdjacencyMatrix() {
        return this.adjacencyMatrix;
    }

    @Override
    public int getNbEdges() {
        return this.nbEdges;
    }

    @Override
    public boolean isEdge(int x, int y) {
        return this.adjacencyMatrix[x][y] == 1;
    }

    @Override
    public void removeEdge(int x, int y) {
        if(this.adjacencyMatrix[x][y] == 1){
            this.adjacencyMatrix[x][y] = 0;
            this.adjacencyMatrix[y][x] = 0;
            this.nbEdges--;
        }
    }

    @Override
    public void addEdge(int x, int y) {
        if(this.adjacencyMatrix[x][y] == 0){
            this.adjacencyMatrix[x][y] = 1;
            this.adjacencyMatrix[y][x] = 1;
            this.nbEdges++;
        }
    }

    @Override
    public List<Integer> getNeighbors(int x) {
        List<Integer> neighbors = new ArrayList<>();
        for(int i = 0; i < this.getNbNodes(); i++){
            if(this.adjacencyMatrix[x][i] == 1)
                neighbors.add(i);
        }
        return neighbors;
    }

    @Override
    public HashMap<Integer, UndirectedNode> getAdjacencyList() {
        return null;
    }
}
