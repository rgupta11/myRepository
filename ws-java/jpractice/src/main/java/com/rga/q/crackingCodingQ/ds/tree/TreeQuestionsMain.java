package com.rga.q.ds.tree;
import com.rga.q.ds.tree.treeutils.Node;
import com.rga.q.ds.tree.treeutils.TreeUtils;


/**
 * Implement a function to check if a tree is balanced. 
 * For the purposes of this question, a balanced tree is defined to be a 
 * tree such that no two leaf nodes differ in distance from the root by more 
 * than one.
 * 
 * Approach 1: Check height of left and right subtree for every node. If difference
 * is more than 1 return false.
 * 
 */
public class TreeQuestionsMain {

    private static Tree createUnbalancedTree() {

        Cache root = new Cache(1);
        Tree tree = new Tree(root);
        tree.insertNode(new Cache(2));
        tree.insertNode(new Cache(5));
        tree.insertNode(new Cache(3));
        tree.insertNode(new Cache(4)); // This insertion might make the tree unbalanced depending on the Tree's insertNode logic
        return tree;
    }

    private static Tree createBalancedTree() {

        Cache root = new Cache(1);
        Tree tree = new Tree(root);
        tree.insertNode(new Cache(2));
        tree.insertNode(new Cache(3));
        tree.insertNode(new Cache(4));
        tree.insertNode(new Cache(5)); // This insertion might make the tree unbalanced depending on the Tree's insertNode logic
        return tree;
    }


    public static void main(String[] args) {
        
        
        Tree tree = createUnbalancedTree();
        //tree.inOrderDisplay(); 

        boolean isBalanced = TreeUtils.isBalanced(tree.getRoot());
        System.out.println("Is tree balanced? " + isBalanced);

        tree = createBalancedTree();
        //tree.inOrderDisplay(); 

        isBalanced = TreeUtils.isBalanced(tree.getRoot());
        System.out.println("Is tree balanced? " + isBalanced);

    }
}
