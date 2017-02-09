package core.node;

/**
 * Created by Steeve Sinigaglia on 09/02/2017.
 */
public class Edge {
    public int from;
    public int to;
    public int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
