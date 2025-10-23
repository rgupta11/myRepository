package com.rga.q.ds.bst;

public class Node {
    private int element;
    private Node left;
    private Node right;
    public Node(int element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    // Getters and Setters
    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
