package com.rga.q.crackingCodingQ.linkedlist;

public class LLProblems {
    
    /* Cracking code Q
    Write code to remove duplicates from an unsorted linked list.
    FOLLOW UP
    How would you solve this problem if a temporary buffer is not allowed?
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



        // Node pointer = ll.head;
        
        // while (pointer != null){
        //     Node runner = pointer;
        //     while (runner.next != null){
        //         if (runner.next.data == pointer.data){
        //             //Remove duplicate
        //             runner.next = runner.next.next;
        //             ll.length--;
        //         }else{
        //             runner = runner.next;
        //         }
        //     }
        //     pointer = pointer.next;
        // }
    }


    public static void main(String[] args) {
        
        LinkedListL ll = new LinkedListL();
        ll.insertBeginning(5);
        ll.insertBeginning(10);
        ll.insertBeginning(20);
        ll.insertBeginning(30);
        ll.insertBeginning(20);
        ll.insertBeginning(10);
        ll.display();

        
         /* 
            Cracking code Q
            Write code to remove duplicates from an unsorted linked list.
            FOLLOW UP
            How would you solve this problem if a temporary buffer is not allowed?
        */
        removeDuplicates(ll);
        System.out.println("After removing duplicates");
        ll.display();

        
    }

}
