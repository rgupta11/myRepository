package com.rga.q.crackingCodingQ.greedy;

/**
 * This is Knapsack type problem to maximize the Job profit with the wait time constraint
 * 
 * Job Sequencing
 * Job   	J1	J2	J3	J4	J5	J6	J7
 * Profit	35	30	25	20	15	12	5
 * Wait 	3	4	4	2	3	1
 *  (Max how much job can wait)

 * Here no pw ratio but arrange Job with their profit order (may be these Jobs are not divisible)
 * Prepare slots - Max wait is 4 
 * 0—>1—>2—>3—4
 * For any Job check the wait time and slot max boundary like J1 can wait 3 units so slot 2—>3 is given … If the slot is occupied then start backward from the slots like 1—>2 or 0—>1 etc
 * Fit all jobs from their profit into slots 

 */
public class JobSeq {
    // create Job seq 
    

    
}
