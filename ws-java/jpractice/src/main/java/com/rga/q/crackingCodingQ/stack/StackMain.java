package com.rga.q.crackingCodingQ.stack;


public class StackMain {
    
    public static void main(String[] args) {
        StackL stk = new StackL();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.display();


        /*
            Describe how you could use a single array to implement three stacks.

            Approach:

        */



        /*
            How would you design a stack which, in addition to push and pop, 
            also has a function min which returns the minimum element? 
            Push, pop and min should all operate in O(1) time.

            Approach:
                1. use int min value to store the latest min
                2. along with data, next also store the min node at time of insertion
                3. Push will compare new data 
                    - if new < min 
                        -> new Node's min point to current min node
                        -> min = new Node 
                    - else (new > min) 
                        -> no action on min
                        -> new Node's min point to current min node
                3. Pop 
                    - if poped node is Min 
                        -> point min to no

        */    

    }
}
