package core;

import core.node.UndirectedNode;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Alexis on 13/01/2017.
 */
public class AdjacencyListUndirectedGraph implements IUndirectedGraph {

    private int nbNodes;
    private int nbEdges;
    private HashMap<Integer, UndirectedNode> adjacencyList;

    public AdjacencyListUndirectedGraph(int[][] matrix){
        this.adjacencyList = new HashMap<>();
        for(int i = 0; i < matrix.length; i++){
            UndirectedNode node = new UndirectedNode(i);
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] == 1)
                    node.addNeighbor(j);
            }
            this.adjacencyList.put(i, node);
        }
        this.nbNodes = this.adjacencyList.size();
        this.nbEdges = 0;
        for(UndirectedNode node : this.adjacencyList.values()){
            this.nbEdges += node.getNbEdges();
        }
        this.nbEdges /= 2;
    }

    public AdjacencyListUndirectedGraph(IUndirectedGraph undirectedGraph){
        this.nbEdges = undirectedGraph.getNbEdges();
        this.nbNodes = undirectedGraph.getNbNodes();
        this.adjacencyList = (HashMap<Integer, UndirectedNode>) undirectedGraph.getAdjacencyList().clone();

    }

    @Override
    public HashMap<Integer, UndirectedNode> getAdjacencyList() {
        return this.adjacencyList;
    }

    @Override
    public int getNbEdges() {
        return nbEdges;
    }

    @Override
    public boolean isEdge(int x, int y) {
        return this.adjacencyList.get(x).hasNeighbor(y);
    }

    @Override
    public void removeEdge(int x, int y) {
        this.adjacencyList.get(x).removeNeighbor(y);
        this.adjacencyList.get(y).removeNeighbor(x);
        this.nbEdges--;
    }

    @Override
    public void addEdge(int x, int y) {
        this.adjacencyList.get(x).addNeighbor(y);
        this.adjacencyList.get(y).addNeighbor(x);
        this.nbEdges++;
    }

    @Override
    public List<Integer> getNeighbors(int x) {
        return this.adjacencyList.get(x).getNeighbors();
    }

    @Override
    public int getNbNodes() {
        return this.nbNodes;
    }

    @Override
    public int[][] toAdjacencyMatrix() {
        int n = this.adjacencyList.size();
        int[][] adjacencyMatrix = new int [n][n];
        for(int i = 0; i < this.adjacencyList.size(); i++) {
            for(int j = 0; j < this.adjacencyList.size(); j++) {
                if(this.adjacencyList.get(i).hasNeighbor(j)) adjacencyMatrix[i][j] = 1;
                else adjacencyMatrix[i][j] = 0;
            }
        }
        return adjacencyMatrix;
    }
}
