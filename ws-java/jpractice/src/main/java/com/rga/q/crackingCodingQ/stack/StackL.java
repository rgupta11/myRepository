package com.rga.q.crackingCodingQ.stack;

import com.rga.q.crackingCodingQ.linkedlist.Node;

public class StackL {
    Node top;
    int length;

    public void push(int data){
        
        Node newN = new Node(data);
        if(top != null){
            //add new node to top.next and move top to new node
            newN.next = top;
        }
        top = newN;
        length++;
    }

    public int pop(){
        if(top == null){
            return -1;
        }
        int retData = top.data;
        top = top.next;
        length--;
        return retData;
    }

    public int peek(){
        if(top == null){
            return -1;
        }
        return top.data;
    }

    public void display(){
        Node pointer = top;
        System.out.println("length: " + length);
        while (pointer != null){
            System.out.println(pointer.data);
            pointer = pointer.next;
        }
    }
}
