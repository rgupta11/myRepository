package com.rga.q.crackingCodingQ.linkedlist;

public class LLProblems {
    
    /* Cracking code Q
        Write code to remove duplicates from an unsorted linked list.
        FOLLOW UP
        How would you solve this problem if a temporary buffer is not allowed?

        Approach 1: with no buffer - nested loops with 1st and 2nd pointer. If 2nd matches first remove it
        Approach 2: with buffer - Traverse and add data to a set. If element is in set remove it and continue
    */
    private static void removeDuplicates(LinkedListL ll){
        
        Node pointer = ll.head;
        while (pointer != null){

            Node runner = pointer;
            //nested while to check duplicate
            while (runner.next != null) { 
                if (runner.next.data == pointer.data) {
                    //delete runner
                    runner.next = runner.next.next;
                    ll.length--;
                }else{
                    runner = runner.next;
                }
            }
            pointer = pointer.next;
        }
    }

    
    /*
     * Implement an algorithm to find the nth to last element of a singly linked list.
     * Approach:
     *  similar to 2 pointer technique
     *  Put 1 pointer at head and other move to n distance ahead
     *  Now traverse until the 2nd pointer reaches LL end
     * 
     */
    static Node getNodeNthToLast(LinkedListL ll, int n){
        
        if (ll.head == null || n < 1){
            return null;
        }

        Node mainPointer = ll.head;
        Node refPointer = ll.head;

        //Move refPointer n nodes ahead
        for (int i = 0; i < n; i++) {
            if (refPointer == null){
                return null; //n is greater than length of linked list
            }
            refPointer = refPointer.next;
        }

        //Move both pointers until refPointer reaches end
        while (refPointer != null){
            mainPointer = mainPointer.next;
            refPointer = refPointer.next;
        }

        System.out.println("Nth to last node is: " + mainPointer.data);
        return mainPointer;
    }


    /*
        Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
        EXAMPLE
        Input: the node ‘c’ from the linked list a->b->c->d->e
        Result: nothing is returned, but the new linked list looks like a->b->d->e

        Approach: 
            Copy data from next node to current node and delete next node
            
            But how to connect parent of current node to next of next node?
            We can't as we don't have access to parent node. 
            Hence we copy data from next node to current node and delete next node.
            Istead we copy next node data to current node and delete next node.

    */
    static void deleteNode(Node n, LinkedListL ll){
        //Todo 
        if (n == null || n.next == null){
            System.out.println("Can't delete the given node");
            return;
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        ll.length--;
    }

    public static void main(String[] args) {
        
        LinkedListL ll = new LinkedListL();
        ll.insertBeginning(5);
        ll.insertBeginning(10);
        ll.insertBeginning(20);
        ll.insertBeginning(30);
        ll.insertBeginning(20);
        ll.insertBeginning(10);


        
         /* 
            Cracking code Q
            Write code to remove duplicates from an unsorted linked list.
            FOLLOW UP
            How would you solve this problem if a temporary buffer is not allowed?

            Test case / edge case:
            1. Empty linked list
            2. Linked list with one element
            3. Linked list with all unique elements
            4. Linked list with all duplicate elements  
        */
        System.out.println("------remove duplicates from an unsorted linked list.-------");
        removeDuplicates(ll);
        System.out.println("After removing duplicates");
        ll.display();
        System.out.println();


        /*
            Implement an algorithm to find the nth to last element of a singly linked list.
            Approach: 

            test cases/ edge case for nth last element 
            1. when n is greater than length of linked list
            2. when n is equal to length of linked list
            3. when n is 0 or negative

        */
        System.out.println("------nth to last element of a singly linked list-------");
        Node nthToLastNode = getNodeNthToLast(ll, 3);
        System.out.println("3rd to last node is: " + nthToLastNode.data);    
        System.out.println();
        
        /*
            Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
            EXAMPLE
            Input: the node ‘c’ from the linked list a->b->c->d->e
            Result: nothing is returned, but the new linked list looks like a->b->d->e
        */
        System.out.println("------delete a node in the middle of a single linked list-------");
        LinkedListL ll2 = createLinkedList(5);
        ll2.display();
        Node n = getRandomNode(ll2, 4);
        deleteNode(n, ll2);
        ll2.display();
        System.out.println();


        /*
            You have two numbers represented by a linked list, where each node contains a single digit. 
            The digits are stored in reverse order, such that the 1’s digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
            EXAMPLE
            Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
            Output: 8 -> 0 -> 8

            carry over element data to next node.

            Approach:
            1. Traverse both linked lists until both are null and carry is 0
            2. Add corresponding node data and carry
            3. Create new node with sum%10
            4. Update carry = sum/10
            5. Move to next nodes in both linked lists  
            6. Return head of new linked list
        */
        //TODO 
        //TODO
        LinkedListL llfirst = createLinkedList(5);
        LinkedListL llsecond = createLinkedList(9);

        LinkedListL llResult = sumLinkedlist(llfirst, llsecond);




        /*
            Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
            DEFINITION
            Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node, so as to make a loop in the linked list.
            EXAMPLE
            input: A -> B -> C -> D -> E -> C [the same C as earlier]
            output: C

            Loop Detection Approach:
            1. Use Floyd’s Cycle-Finding Algorithm (Tortoise and Hare Algorithm)
            2. Initialize two pointers, slow and fast, both pointing to head of linked list
            3. Move slow pointer by one node and fast pointer by two nodes in each iteration
            4. If there is a loop, slow and fast pointers will eventually meet inside the loop
            5. If fast pointer reaches null, there is no loop
            6. To find the starting node of the loop, reset one pointer to head and move both pointers 
                one node at a time until they meet again; the meeting point is the start of the loop

            How to find the node where the loop starts?
            1. Once a loop is detected (slow == fast), keep one pointer at the meeting point
            2. Move the other pointer to the head of the linked list
            3. Move both pointers one node at a time; the node where they meet is the start of the loop
            Example:
            LL - 1 2 3 4 5 6 4
        1. Detect loop using Floyd’s algorithm
        2. Meeting point is at node with value 5
        3. Move one pointer to head (1) and keep other at meeting point (5)
        4. Move both pointers one step at a time:
            - Step 1: Pointer1 at 2, (check P1 & P2 if same break) else Pointer2 at 6
            - Step 2: Pointer1 at 3, (check P1 & P2 if same break) else Pointer2 at  4
            - Step 3: Pointer1 at 4, (check P1 & P2 if same break) else Pointer2 at  5
        Is this correct that we check P1 & P2 before incrementing p2?
        */

        

    }

    private static LinkedListL sumLinkedlist(LinkedListL llfirst, LinkedListL llsecond){
        LinkedListL result = null;
        //Loop until both LLs are null and carry is 0
        //The % will give the unit digit
        //The / will give the carry over digit
        

        return result;
    }

    private static LinkedListL createLinkedList(int n){
        LinkedListL ll = new LinkedListL();
        for (int i = n; i > 0; i--) {
            ll.insertBeginning(i);
        }
        return ll;
    }

    private static Node getRandomNode(LinkedListL ll, int data){
        Node pointer = ll.head;
        while (pointer != null){
            if (pointer.data == data){
                return pointer;
            }
            pointer = pointer.next;
        }
        return null;
    }
}
