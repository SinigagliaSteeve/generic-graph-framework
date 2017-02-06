package core.node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexis on 13/01/2017.
 */
public class UndirectedNode extends Node {

    private List<Integer> neighbors = new ArrayList<>();

    public UndirectedNode(Integer num) {
        this.num = num;
    }

    public UndirectedNode(int num, List<Integer> neighbors) {
        this.num = num;
        this.neighbors = neighbors;
    }


    public List<Integer> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Integer> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbor(Integer num){
        if(!this.neighbors.contains(num))
            this.neighbors.add(num);
    }

    public void removeNeighbor(Integer num){
        if(this.neighbors.contains(num))
            this.neighbors.remove(num);
    }

    public boolean hasNeighbor(int num){
        return this.neighbors.contains(num);
    }

    public int getNbEdges(){
        return this.neighbors.size();
    }
}