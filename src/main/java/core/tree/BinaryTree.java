package core.tree;

import core.node.DirectedNode;
import core.node.Node;

import java.util.ArrayList;

/**
 * Created by Steeve Sinigaglia on 27/01/2017.
 */
public class BinaryTree {

    public ArrayList<Node> tree;

    public BinaryTree() {
        this.tree = new ArrayList<>();
    }

    /**
     * Insert new value in the tree.
     *
     * @param node the new value.
     */
    public void insertValue(Node node) {
        this.tree.add(node);
        if (tree.size() > 1) {
            int idxFather = getIdxFather(node);
            percolateUp(tree.get(idxFather), node);
        }
    }

    /**
     * Remove the lowest value (root) of the tree.
     */
    public void removeLowestValue() {
        Node root = this.tree.get(0);
        Node lastLeaf = this.tree.get(this.tree.size() - 1);

        compute(root, lastLeaf);
        this.tree.remove(root);
        percolateDown(lastLeaf);
    }


    /**
     * Check if father value is superior than son value.
     * If true, compute them and recursive.
     *
     * @param father the node father
     * @param son    the node son
     */
    private void percolateUp(Node father, Node son) {
        if (father.getNum() > son.getNum()) {
            compute(father, son);
            father = tree.get(getIdxFather(son));
            percolateUp(father, son);
        }
    }

    /**
     * Check if the value of sons of the current node are superior to the current node value.
     * If false, compute and recursive.
     *
     * @param node current node to look its sons.
     */
    private void percolateDown(Node node) {
        int idxCurrentNode = tree.indexOf(node);
        if (tree.size() - 1 < idxCurrentNode * 2 + 2) {
            return;
        }

        Node son1 = tree.get(idxCurrentNode * 2 + 1);
        Node son2 = tree.get(idxCurrentNode * 2 + 2);

        Node finalNode = compareAndGetLowest(son1, son2);
        if (node.getNum() > finalNode.getNum()) {
            compute(node, finalNode);
            percolateDown(node);
        }
    }

    /**
     * Compute 2 nodes in the tree.
     *
     * @param n1 first node.
     * @param n2 second node.
     */
    private void compute(Node n1, Node n2) {
        int idx1 = tree.indexOf(n1);
        int idx2 = tree.indexOf(n2);
        this.tree.set(idx1, n2);
        this.tree.set(idx2, n1);
    }

    /**
     * Return the father index of the current node (son).
     *
     * @param son node to get father index.
     * @return the index of the father.
     */
    private int getIdxFather(Node son) {
        return (this.tree.indexOf(son) - 1) / 2;
    }

    /**
     * Compare two node (their value) and return the node wich have the lowest value
     *
     * @param n1 first node
     * @param n2 second node
     * @return the lowest node
     */
    private Node compareAndGetLowest(Node n1, Node n2) {
        if (n1.getNum() > n2.getNum()) return n2;
        return n1;
    }


    /**
     * Get the list of Node.
     *
     * @return list of Node (Tree).
     */
    public ArrayList<Node> getTree() {
        return tree;
    }
}
