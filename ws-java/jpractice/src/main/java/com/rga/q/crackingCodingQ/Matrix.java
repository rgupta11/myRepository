package com.rga.q.crackingCodingQ;

public class Matrix {
    
    public enum Direction {
        CLOCKWISE,
        ANTICLOCKWISE
    }
    
    static void printMatrix(int[][] mat, int r, int c){
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* Generate a matrix with values for testing */
    static int[][] genMatrix(int r, int c) {
        int[][] mat = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = i * c + j;
            }
        }
        printMatrix(mat, r, c);
        return mat;
    }

    /*
        Given an image represented by an NxN matrix, where each pixel in the image is 
            4 bytes, write a method to rotate the image by 90 degrees. 
            Can you do this in place?

            - only a square matrix liek NxN can be rotated inplace
            - 1) 90 degree clockwise or antiClockwise ? Impl could be diff
                    - 90 degree clockwise : (i, j) -> (j, n-1-i)
                    - 90 degree antiClockwise : (i, j) -> (n-1-j, i)
            - 2) as per Striver's video on Matrix rotation 
                    https://www.youtube.com/watch?v=Z0R2u6gd3GU
            - 3) Brute force O(n^2) 
                - for i 
                -   for j 
                -       mat[j][n-1-i] = [i][j]; // clockwise
                -       OR mat[n-1-i][j] = [i][j]; // anti clockwise
    */
    static int[][] rotate90Brute(int[][] mat, int n, Direction dir){
        //direction
        int[][] result = new int[n][n];
        if(dir == Direction.CLOCKWISE){
            System.out.println("Clockwise rotation");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {        
                    result[j][n-1-i] = mat[i][j];
                }
            }
        } else { //ANTICLOCKWISE
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    result[n-1-j][i] = mat[i][j];
                }
            }
        }
        return result;
    }

    /*

    */
    static int[][] rotate90(int[][] mat, int n){
        // Step 1: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }
        return mat;
    }
    
    public static void main(String[] args){


        /* -----------------------------------------
            Given an image represented by an NxN matrix, where each pixel in the image is 
            4 bytes, write a method to rotate the image by 90 degrees. 
            Can you do this in place?
        */

        /* ----soln
            - only a square matrix liek NxN can be rotated inplace
            - 1) 90 degree clockwise or antiClockwise ? Impl could be diff
                    - 90 degree clockwise : (i, j) -> (j, n-1-i)
                    - 90 degree antiClockwise : (i, j) -> (n-1-j, i)
            - 2) as per Striver's video on Matrix rotation 
                    https://www.youtube.com/watch?v=Z0R2u6gd3GU
            - 3) Brute force O(n^2) 
                - for i 
                -   for j 
                -       mat[j][n-1-i] = mat[i][j]; // clockwise
                -       OR mat[n-1-i][j] = [i][j]; // anti clockwise
            - 4) Diagnal values remain same and values  O(n) 
                - 2 step process
                - Transpose 
                - Reverse the row
        */
        int r = 4, c =4;
        int[][] mat = genMatrix(r, c);
        

        System.out.println("After rotation bruteForce: ");
        printMatrix(rotate90Brute(mat, r, Direction.CLOCKWISE), r, c);
        
        System.out.println("----------------------- ");
        mat = genMatrix(r, c);
        System.out.println("After rotation efficient: ");
        printMatrix(rotate90(mat, r), r, c);

        /* --------------------------------------
            Write an algorithm such that if an element in an MxN matrix is 0, 
            its entire row and column is set to 0.
        */ 

    }

}
