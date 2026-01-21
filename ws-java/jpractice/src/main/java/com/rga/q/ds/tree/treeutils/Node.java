package com.rga.q.ds.tree.treeutils;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }
        
    public void subDivide() {
        // Implementation for subdividing the node into four quadrants
    }

    private List<Node> children = new ArrayList<>();

    public List<Node> getChildren() {
        return children;
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
