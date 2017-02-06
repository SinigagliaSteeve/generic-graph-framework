package core.node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexis on 13/01/2017.
 */
public class DirectedNode extends Node {

    private List<Integer> successors = new ArrayList<>();
    private List<Integer> predecessors = new ArrayList<>();
    private int weight;

    public DirectedNode(Integer num) {
        this.num = num;
        this.successors = new ArrayList<>();
        this.predecessors = new ArrayList<>();
    }

    public DirectedNode(Integer num, int weight) {
        this.num = num;
        this.successors = new ArrayList<>();
        this.predecessors = new ArrayList<>();
        this.weight = weight;
    }

    public List<Integer> getSuccessors() {
        return successors;
    }

    public void setSuccessors(List<Integer> successors) {
        this.successors = successors;
    }

    public void addSuccessor(Integer num){
        if(!this.successors.contains(num))
            this.successors.add(num);
    }

    public void removeSuccessor(Integer num){
        if(this.successors.contains(num))
            this.successors.remove(num);
    }

    public boolean hasSuccessor(Integer num){
        return this.successors.contains(num);
    }

    public List<Integer> getPredecessors() {
        return predecessors;
    }

    public void setPredecessors(List<Integer> predecessors) {
        this.predecessors = predecessors;
    }

    public void addPredecessor(Integer num){
        if(!this.predecessors.contains(num))
            this.predecessors.add(num);
    }

    public void removePredecessor(Integer num){
        if(this.predecessors.contains(num))
            this.predecessors.remove(num);
    }

    public boolean hasPredecessor(Integer num){
        return this.predecessors.contains(num);
    }

    public int getNbArcs(){
        return this.successors.size();
    }

}
