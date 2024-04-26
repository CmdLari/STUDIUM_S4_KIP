import java.util.ArrayList;
import java.util.List;

public class Node {
    private int value;
    private Node parent;
    private List<Node> children;

    /**
     * constructor for root node
     */
    public Node() {
        this.value = 0;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    /**
     * constructor for connecting nodes
     * @param parent
     */
    public Node(Node parent) {
        this.value = 0;
        this.parent = parent;
        this.children = new ArrayList<>();
        parent.addChild(this);
    }

    /**
     * constructor for leaf nodes
     * @param value
     * @param parent
     */
    public Node(int value, Node parent) {
        this.value = value;
        this.parent = parent;
        parent.addChild(this);
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public boolean isLeaf() {
        return children==null;
    }
}
