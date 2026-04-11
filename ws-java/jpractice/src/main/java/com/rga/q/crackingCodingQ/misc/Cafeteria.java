package com.rga.q.misc;

/**
 * Java cafeteria problem N seats with k=1 and occupied seats 2,6.
 * Find which seat can be occupied
 * Find total no of seats that can be occupied
 * 
 * Not ideal for K >1
 */

public class Cafeteria {

    public static void main (String[] args){

        int n = 10; //total seats
        int[] occupiedSeats = {2,6};
        boolean[] seats = new boolean[n];
        int factor = 2; //k=1
        //mark occupied seats
        for (int seat : occupiedSeats){
            seats[seat-1] = true;
        }

        //find which seat can be occupied
        for (int i=0; i<seats.length; i++){
            if (!seats[i]){
                boolean canBeOccupied = true;
                if (i-factor >=0 && seats[i-factor]){//left seat occupied
                    canBeOccupied = false;
                }
                if (i+factor < seats.length && seats[i+factor]){//right seat occupied
                    canBeOccupied = false;
                }
                if (canBeOccupied){
                    seats[i] = true;
                    System.out.println("Seat " + (i+1) + " can be occupied");   
                }
            }
        }

    }
    
}
