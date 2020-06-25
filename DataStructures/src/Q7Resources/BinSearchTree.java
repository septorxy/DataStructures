package Q7Resources;

public class BinSearchTree {
    private Node root;

    public BinSearchTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void insert(Node parent, Node newNode) {
        if (parent == null) {
            root = newNode;
        } else if (parent.getData() < newNode.getData()) {
            if (parent.right == null)
                parent.right = newNode;
            else
                insert(parent.right, newNode);
        } else {
            if (parent.left == null)
                parent.left = newNode;
            else
                insert(parent.left, newNode);
        }
    }

    public void show(Node parent) {
        if (parent != null) {
            show(parent.left);
            System.out.println(parent.getData());
            show(parent.right);
        }
    }
}