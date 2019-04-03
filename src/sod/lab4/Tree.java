package sod.lab4;

import static java.lang.Math.abs;

public class Tree {
    private Node root = null;

    public void add(int value) {
        Node node = new Node(value);
        if ( root != null ) {
            if ( node.key%2 == 0 ) {
                addEven(node, root);
            } else {
                addOdd(node, root);
            }
        } else {
            root = node;
        }
    }

    public void print() {
        if ( root != null ) {
            printInfixOrder(root);
            System.out.println();
        } else {
            System.out.println("Tree is empty");
        }

    }

    public int height() {
        return height(root);
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private void addOdd(Node node, Node parent) {
        if ( parent.key % 2 != 0 ) {
            if (node.key <= parent.key) {
                if ( parent.left != null ) {
                    addOdd(node, parent.left);
                } else {
                    parent.left = node;
                }
            } else {
                if ( parent.right != null ) {
                    addOdd(node, parent.right);
                } else {
                    parent.right = node;
                }
            }
        } else {
            if( parent.right != null ) {
                addOdd(node, parent.right);
            } else {
                parent.right = node;
            }
        }
    }

    private void addEven(Node node, Node parent) {
        if ( parent.key % 2 == 0 ) {
            if ( node.key >= parent.key ) {
                if (parent.left != null) {
                    addEven(node, parent.left);
                } else {
                    parent.left = node;
                }
            } else {
                if (parent.right != null) {
                    addEven(node, parent.right);
                } else {
                    parent.right = node;
                }
            }
        } else {
            if ( parent.left != null ) {
                addEven(node, parent.left);
            } else {
                parent.left = node;
            }
        }
    }

    private int height(Node node) {
        return ( node == null ) ? 0: 1 + Math.max(height(node.left), height(node.right));
    }

    private boolean isBalanced(Node root) {
        return ( root == null ) ||
                ( isBalanced(root.left) &&
                        isBalanced(root.right) &&
                        abs(height(root.left) - height(root.right)) <=1 );
    }

    private void printInfixOrder(Node parent) {
        if (parent.left != null) {
            printInfixOrder(parent.left);
        }
        System.out.print(parent.key + " ");
        if (parent.right != null) {
            printInfixOrder(parent.right);
        }
    }

    private class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

}