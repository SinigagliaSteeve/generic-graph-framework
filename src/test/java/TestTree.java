import core.node.DirectedNode;
import core.node.Node;
import core.tree.BinaryTree;

/**
 * Created by Steeve Sinigaglia on 27/01/2017.
 */
public class TestTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insertValue(new DirectedNode(11));
        tree.insertValue(new DirectedNode(10));
        tree.insertValue(new DirectedNode(6));
        tree.insertValue(new DirectedNode(12));
        tree.insertValue(new DirectedNode(14));
        tree.insertValue(new DirectedNode(9));
        tree.insertValue(new DirectedNode(4));

        for (Node n : tree.getTree()){
            System.out.println(n);
        }

        System.out.println("-------------");
        System.out.println("Test remove");
        tree.removeLowestValue();

        for (Node n : tree.getTree()){
            System.out.println(n);
        }

    }
}
