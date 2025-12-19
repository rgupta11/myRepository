package com.rga.q.crackingCodingQ.linkedlist;

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
