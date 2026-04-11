package com.rga.q.ds.tree;

import com.rga.q.ds.tree.treeutils.Node;

//create and manage tree nodes.
public class Tree {
    
    private Node root;
    public Node getRoot() {
        return root;
    }   

    public Tree(Node root){
        this.root = root;
    }

    public Node insertNode(Node node) {
        root = insertNode(root, node);
        return root;
    }

    private Node insertNode(Node current, Node node) {  
        if (current == null) {
            return node;
        }
        if (node.getData() < current.getData()) {
            current.setLeft(insertNode(current.getLeft(), node));
        } else if (node.getData() > current.getData()) {
            current.setRight(insertNode(current.getRight(), node));
        }
        return current;
    }


    public void inOrderDisplay() {
        inOrderTraversal(root);
    }

    public void PreOrderDisplay() {
        preOrderTraversal(root);
    }

    public void postOrderDisplay() {
        postOrderTraversal(root);
    }   

    private void inOrderTraversal(Node node) {
        inOrderTraversal(node.getLeft());
        System.out.println(node.getData());
        inOrderTraversal(node.getRight());
    }
    
    private void preOrderTraversal(Node node) {
        System.out.println(node.getData());
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

    private void postOrderTraversal(Node node) {
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.println(node.getData());
    }

}
