package com.rga.q.ds.tree.treeutils;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int id;
    private String data;

    public Node(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void subDivide() {
        // Implementation for subdividing the node into four quadrants
    }

    private List<Node> children = new ArrayList<>();

    public List<Node> getChildren() {
        return children;
    }
}
