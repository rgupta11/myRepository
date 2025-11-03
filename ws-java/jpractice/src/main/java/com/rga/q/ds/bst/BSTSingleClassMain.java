package com.rga.q.ds.bst;

class BSTSingleCNode{

    int value;
    BSTSingleCNode leftNode;
    BSTSingleCNode rightNode;

    public BSTSingleCNode(int value){
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public int getValue(){
        return value;
    }
    public void setValue(int value){
        this.value = value;
    }

    public BSTSingleCNode getLeft(){
        return this.leftNode;
    }
    public BSTSingleCNode getRight(){
        return this.rightNode;
    }

    public void setRightN(BSTSingleCNode node){
        this.rightNode = node;
    }
    public void setLeftN(BSTSingleCNode node){
        this.leftNode = node;
    }

}

class BSTSingleClass {
    private BSTSingleCNode root;


    public void insert(int value){
        BSTSingleCNode newNode = new BSTSingleCNode(value);
        insertNode(newNode);
    }
    
    private void insertNode(BSTSingleCNode node){
        if(root == null){
            this.root = node;
            return;
        }
        
        insertNodeRecursive(root, node);
    }
    
    private void insertNodeRecursive(BSTSingleCNode current, BSTSingleCNode newNode){
        if(newNode.getValue() < current.getValue()){
            if(current.getLeft() == null){
                current.setLeftN(newNode);
            } else {
                insertNodeRecursive(current.getLeft(), newNode);
            }
        } else {
            if(current.getRight() == null){
                current.setRightN(newNode);
            } else {
                insertNodeRecursive(current.getRight(), newNode);
            }
        }
    }
 
    
}

public class BSTSingleClassMain{

    public static void mani(String[] args){

    }
}
