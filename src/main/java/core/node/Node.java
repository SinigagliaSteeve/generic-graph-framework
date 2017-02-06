package core.node;

/**
 * Created by Steeve Sinigaglia on 11/01/2017.
 */
public abstract class Node {
    protected int num;
    protected Integer poids;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            return ((Node) obj).getNum() == this.num;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + num + "]";
    }
}
