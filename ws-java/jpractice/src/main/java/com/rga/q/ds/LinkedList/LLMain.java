package com.rga.q.ds.LinkedList;

class Node {
        
    int data; 
    Node next;
    
    Node(int data){
        this.data = data;
        this.next = null;
    } 
}

class LinkedListL {

    Node head;
    int length;

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

public class LLMain {
    
 

    public static void main(String[] args) {
        LinkedListL ll = new LinkedListL();
        ll.insertBeginning(10);
        ll.insertBeginning(20);
        ll.insertBeginning(30);
        ll.insertBeginning(5);
        ll.display(); // Output: 5 -> 30 -> 20 -> 10 -> null

        ll.deleteNode(20);
        ll.display(); // Output: 5 -> 30 -> 10 -> null

        System.out.println("Length of LinkedList: " + ll.length); // Output: 3
    }
    
}
