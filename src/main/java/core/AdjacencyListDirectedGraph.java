package core;

import core.node.DirectedNode;
import core.node.UndirectedNode;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Alexis on 19/01/2017.
 */
public class AdjacencyListDirectedGraph implements IDirectedGraph {

    private int nbNodes;
    private int nbArcs;
    private HashMap<Integer, DirectedNode> adjacencyList;

    public AdjacencyListDirectedGraph(int[][] matrix){
        this.adjacencyList = new HashMap<>();
        for(int i = 0; i < matrix.length; i++){
            this.adjacencyList.put(i, new DirectedNode(i));
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] == 1){
                    this.adjacencyList.get(i).addSuccessor(j);
                    this.adjacencyList.get(j).addPredecessor(i);
                }
            }
        }
        this.nbNodes = this.adjacencyList.size();
        this.nbArcs = 0;
        for(DirectedNode node : this.adjacencyList.values()){
            this.nbArcs += node.getNbArcs();
        }
    }

    public AdjacencyListDirectedGraph(IDirectedGraph directedGraph){
        this.nbArcs = directedGraph.getNbArcs();
        this.nbNodes = directedGraph.getNbNodes();
        this.adjacencyList = (HashMap<Integer, DirectedNode>) directedGraph.getAdjacencyList().clone();
    }

    @Override
    public HashMap<Integer, DirectedNode> getAdjacencyList() {
        return this.adjacencyList;
    }

    @Override
    public int getNbNodes() {
        return this.nbNodes;
    }

    @Override
    public int getNbArcs() {
        return this.nbArcs;
    }

    @Override
    public boolean isArc(int from, int to) {
        return this.adjacencyList.get(from).hasSuccessor(to);
    }

    @Override
    public void removeArc(int from, int to) {
        this.adjacencyList.get(from).removeSuccessor(to);
        this.adjacencyList.get(to).removePredecessor(from);
        this.nbArcs--;
    }

    @Override
    public void addArc(int from, int to) {
        this.adjacencyList.get(from).addSuccessor(to);
        this.adjacencyList.get(to).addPredecessor(from);
        this.nbArcs++;
    }

    @Override
    public List<Integer> getSuccessors(int x) {
        return this.adjacencyList.get(x).getSuccessors();
    }

    @Override
    public List<Integer> getPredecessors(int x) {
        return this.adjacencyList.get(x).getPredecessors();
    }

    @Override
    public int[][] toAdjacencyMatrix() {
        int n = this.adjacencyList.size();
        int[][] adjacencyMatrix = new int [n][n];
        for(int i = 0; i < this.adjacencyList.size(); i++) {
            for(int j = 0; j < this.adjacencyList.size(); j++) {
                if(this.adjacencyList.get(i).hasSuccessor(j)) adjacencyMatrix[i][j] = 1;
                else adjacencyMatrix[i][j] = 0;
            }
        }
        return adjacencyMatrix;
    }

    @Override
    public IDirectedGraph computeInverse() {
        AdjacencyListDirectedGraph inverseGraph = new AdjacencyListDirectedGraph(this);
        for(DirectedNode node : inverseGraph.adjacencyList.values()){
            List<Integer> tmp = node.getSuccessors();
            node.setSuccessors(node.getPredecessors());
            node.setPredecessors(tmp);
        }
        return inverseGraph;
    }
}
