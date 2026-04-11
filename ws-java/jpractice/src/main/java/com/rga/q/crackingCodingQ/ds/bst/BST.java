package com.rga.q.ds.bst;

public class BST {

    private BSTNode root;
    //getter and setter
    public BSTNode getRoot() { 
        return root; 
    }

    public BST() {
        this.root = null;
    }

    // Insert a new element into the BST
    public void insert(int element) {
        root = insertRec(root, element);
    }

    private BSTNode insertRec(BSTNode root, int element) {
        if (root == null) {
            root = new BSTNode(element);
            return root;
        }
        if (element < root.getElement()) {
            root.setLeft(insertRec(root.getLeft(), element));
        } else if (element > root.getElement()) {
            root.setRight(insertRec(root.getRight(), element));
        }
        return root;
    }

    // Search for an element in the BST
    public boolean search(int element) {
        return searchRec(root, element);
    }

    private boolean searchRec(BSTNode root, int element) {
        if (root == null) {
            return false;
        }
        if (element == root.getElement()) {
            return true;
        }
        if (element < root.getElement()) {
            return searchRec(root.getLeft(), element);
        } else {
            return searchRec(root.getRight(), element);
        }
    }

    // Inorder traversal of the BST
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.getLeft());
            System.out.print(root.getElement() + " ");
            inorderRec(root.getRight());
        }
    }

    //preorder traversal of the BST
    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(BSTNode root) {
        if (root != null) {
            System.out.print(root.getElement() + " ");
            preorderRec(root.getLeft());
            preorderRec(root.getRight());
        }
    }

    //postorder traversal of the BST
    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(BSTNode root) {
        if (root != null) {
            postorderRec(root.getLeft());
            postorderRec(root.getRight());
            System.out.print(root.getElement() + " ");
        }
    }

}
