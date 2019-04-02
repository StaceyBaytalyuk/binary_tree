import static java.lang.Math.abs;

public class Tree {
    private Node root = null;

    public void add(int value) {
        Node node = new Node(value);
        if ( root != null ) {
            addNode(node, root);
        } else {
            root = node;
        }
    }

    public void print() {
        printInfixOrder(root);
        System.out.println();
    }

    public int height() {
        return height(root);
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

//================================================================

    private int height(Node node) {
        return ( node == null ) ? 0: 1 + Math.max(height(node.left), height(node.right));
    }

    private boolean isBalanced(Node root) {
        return ( root == null ) ||
                ( isBalanced(root.left) &&
                        isBalanced(root.right) &&
                        abs(height(root.left) - height(root.right)) <=1 );
    }

    private void printInfixOrder(Node parent) { // инфиксный обход
        if (parent.left != null) {
            printInfixOrder(parent.left);
        }
        System.out.print(parent.key + " ");
        if (parent.right != null) {
            printInfixOrder(parent.right);
        }
    }

    private void addNode(Node item, Node parent) {
        if (item.key > parent.key) {
            if ( parent.right != null ) {
                addNode(item, parent.right);
            } else {
                parent.right = item;
            }
        } else {
            if ( parent.left != null ) {
                addNode(item, parent.left);
            } else {
                parent.left = item;
            }
        }
    }

    private class Node {
        int key;
        Node left;
        Node right;
        Node parent;

        Node(int key) {
            this.key = key;
        }
    }

}