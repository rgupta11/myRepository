package com.rga.q.ds.tree;

import com.rga.q.ds.tree.treeutils.Node;

//create and manage tree nodes.
public class Tree {
    
    private Cache root;
    public Cache getRoot() {
        return root;
    }   

    public Tree(Cache root){
        this.root = root;
    }

    public Cache insertNode(Cache node) {
        root = insertNode(root, node);
        return root;
    }

    private Cache insertNode(Cache current, Cache node) {  
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

    private void inOrderTraversal(Cache node) {
        inOrderTraversal(node.getLeft());
        System.out.println(node.getData());
        inOrderTraversal(node.getRight());
    }
    
    private void preOrderTraversal(Cache node) {
        System.out.println(node.getData());
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

    private void postOrderTraversal(Cache node) {
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.println(node.getData());
    }

}
