package com.rga.q.crackingCodingQ.linkedlist;

public class LinkedListL {

    public Node head;
    public int length;

    public LinkedListL(){
        head = null;
        length = 0;
    }

    public void insertBeginning(int data){
        
        Node newN = new Node(data);
        newN.next = head;
        head = newN;
        length++;
        
    }
    
    public int deleteNode(int data){
        
        //Head is n
        if(head.data == data){
            head = head.next;
            length--;
            return data;
        }
        Node pointer = head;
        while (pointer.next != null){
        
            if (pointer.next.data == data){                
                pointer.next = pointer.next.next;
                length--;
                return data;
            }
            pointer = pointer.next;
        }
        return -1;
    }

    public void display(){
        Node pointer = head;
        System.out.println("length: " + length);
        while (pointer != null){
            System.out.println(pointer.data);
            pointer = pointer.next;
        }
    }
}