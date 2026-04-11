package com.rga.q.ds.bst;

public class BSTNode {
    private int element;
    private BSTNode left;
    private BSTNode right;
    public BSTNode(int element) {
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

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
}
