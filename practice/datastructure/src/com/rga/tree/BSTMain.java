package com.rga.tree;

public class BSTMain {

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        System.out.println("Inorder traversal:");
        bst.inorder();
        System.out.println("\nPreorder traversal:");
        bst.preorder();
        System.out.println("\nPostorder traversal:");
        bst.postorder();
    }

}
