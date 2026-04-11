package com.rga.q.greedy;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Greedy
Used to solve optimising problems. 
Require either minimum or max result
Problem P to travel from location A —> B
Walk
Bike
Car
Train
Flight ..etc
Constraint/condition 
only by flight or train. Then these become feasible solutions ie satisfying the constraints.
OR cover the journey in min cost say 12 hr
Its a minimisation problem
Optimal solution - Its already feasible as only by train but with min time satisfying both conditions means its the Optimal solution
There could be multiple feasible solution but only 1 Optimal solution 
Maximisation problem
If a problem require either a minimum or maximum result then its called Optimisation problem
E.g.
Selecting a best car - based of my sorting I’ll pick
Selecting a candidate - Is he the best person as per your criteria he is most optimal.
Own method / known methods and quickly solve it then its greedy

Knapsack problem
Given 7 objects and Bag capacity is 15 
7 objects are given and each object 
Objects -    1    2    3    4    5     6     7 
Profits -     10   5    6    8    9    11
Weights - 
Capacity - 15
Container/Capacity - Objects > capacity
Fill such that profit is maximization
Its a problem for those objects which are divisible (fractions)
 *
 * List of objects
 *  name - x1, x2,...
 *  profit - 
 *  weight
 * 
 *  Sorted set for Objects/Sort them on Profit/Weight
 * 
 * Iterate through each objectList and calculate p/w and store it in sorted set
 *
 * Now woth sorted set, pick top objects and check how many wt can be taken .. 
 * note the wt counter will start from mx wt say 15 and keep on decrementing it 
 */
public class Knapsack {

    class GreedyObject implements Comparable<GreedyObject> {
        
        String name;
        Integer weight;
        Integer profit;
        Double pwRatio;

        public GreedyObject(String name, Integer weight, Integer profit) {
            this.name = name;
            this.weight = weight;
            this.profit = profit;
            this.pwRatio = (double) profit/weight;
        }

        @Override
        public int compareTo(GreedyObject obj){
            return Double.compare(this.pwRatio, obj.pwRatio);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public Integer getProfit() {
            return profit;
        }

        public void setProfit(Integer profit) {
            this.profit = profit;
        }

        public Double getPwRatio() {
            return pwRatio;
        }
    }

    public static void main(String[] args) {
       
       
       //Knapsack problem - fractions are allowed (Container loading with fractions)
       //Objects - weight, profit, pwRatio etc
       //later fill bag with max allowed wt keeping profit max ..
       // Refer above docs
        SortedSet<GreedyObject> sorted = new TreeSet<GreedyObject>();    
    }
    

    
}
