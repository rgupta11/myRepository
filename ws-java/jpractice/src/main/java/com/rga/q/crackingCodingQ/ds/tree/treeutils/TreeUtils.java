package com.rga.q.ds.tree.treeutils;

public class TreeUtils {
    
    
    /**Height 
     * Approach:
     * 1. If node is null return 0 
     * 2. Else return 1 + max(height(left), height(right))
    */
    public static int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    /**
     * A tree is balanced if the heights of left and right subtree
     * differ by no more than 1 for every node in the tree.
     * 
     * Approach:
     * 1. Get height of left and right subtree
     * 2. If difference is more than 1 return false
     * 3. Else return true if left and right subtree are balanced
     * 
     * */
    public static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        int leftHeight = TreeUtils.height(root.getLeft());
        int rightHeight = TreeUtils.height(root.getRight());

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        } else {
            return isBalanced(root.getLeft()) && isBalanced(root.getRight());
        }
    }

}
