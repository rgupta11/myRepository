package com.rga.q.crackingCodingQ.greedy;

public class GasStation {

    /**
     * There are n gas stations along a circular route. 
     * You are given two integer arrays gas and cost of length n. 
     * At each gas station i, gas[i] represents the amount of gas you receive by stopping
     * at this station, and cost[i] represents the amount of gas required to travel from 
     * station i to the next station. You begin the journey with an empty tank at one 
     of the gas stations.
     * 
     * Write a function to return the starting gas station's index if you can travel around the 
     * circuit once in the clockwise direction; otherwise, return -1. Note that if there exists a 
     * solution, it is guaranteed to be unique. Also, you can only travel 
     * from station i to station i + 1, and the last station will lead back to the first station
     * 
     * explanation:
     * Start at station 4 (index 3) and fill up with 3 units of gas. Your tank = 0 + 3 = 3 
     * Travel to station 4 with 1 unit of gas, and fill up with 3 units of gas. 
     * Your tank = 3 - 1 + 3 = 5 Travel to station 0 with 1 unit of gas, and fill up with 5 units 
     * of gas. Your tank = 5 - 1 + 5 = 9 Travel to station 1 with 5 units of gas, and fill up 
     * with 2 units of gas. Your tank = 9 - 5 + 2 = 6 Travel to station 2 with 5 units of gas, 
     * and fill up with 0 units of gas. Your tank = 6 - 5 + 0 = 1 Travel back to station 3 with 1 
     * unit of gas to complete the circuit. Therefore, return 3 as the starting index.
     * 
     * Input: gas = [5,2,0,3,3], cost = [1,5,5,1,1]
     * Output: 3
     * Explanation: 
     * Start at station 3 (index 3) and fill up with 3 unit of gas. Your tank = 0 + 3 = 3
     * Travel to station 4 with 1 unit of gas, and fill up with 3 unit of gas. Your tank = 3 - 1 + 3 = 5
     * Travel to station 0 with 1 unit of gas, and fill up with 5 unit of gas. Your tank = 5 - 1 + 5 = 9
     * Travel to station 1 with 5 unit of gas, and fill up with 2 unit of gas. Your tank = 9 - 5 + 2 = 6
     * Travel to station 2 with 5 unit of gas, and fill up with 0 unit of gas. Your tank = 6 - 5 + 0 = 1
     * Travel to station 3 with 1 unit of gas to complete the circuit.
     * Therefore, return 3 as the starting index.
     * 
     * Approach: Greedy approach
     * 1. Calculate the total gas and total cost. If total gas is less than total cost, return -1 because it's not possible to complete the circuit.
     * 2. If total gas is greater than or equal to total cost, then there must be a solution. 
     * Initialize a variable to keep track of the current gas in the tank and a variable to keep track of 
     * the starting station index. Iterate through the gas stations and update the current gas in the tank 
     * by adding the gas at the current station and subtracting the cost to travel to the next station. 
     * If at any point the current gas in the tank becomes negative, it means that the starting station 
     * index is not valid, so update the starting station index to the next station and reset the current 
     *  gas in the tank to 0.
     * 
     * 
     */

     public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startingStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];

            if (currentGas < 0) {
                startingStation = i + 1; // Move to the next station
                currentGas = 0; // Reset current gas
            }
        }

        return totalGas >= totalCost ? startingStation : -1;    
    }

    public static void main(String[] args){
        int[] gas = {5,2,0,3,3};
        int[] cost = {1,5,5,1,1};
        int startingStation = canCompleteCircuit(gas, cost);
        System.out.println("Starting station index: " + startingStation);
    }


    
}
