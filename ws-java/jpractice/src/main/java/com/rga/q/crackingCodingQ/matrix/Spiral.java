package com.rga.q.matrix;

import java.util.List;

public class Spiral {
    
    /**
     * Spiral Matrix
     * 
     * Write a function to traverse an m x n matrix in spiral order and return all elements in a 
     * single list. The traversal should start from the top left corner and proceed clockwise, 
     * spiraling inward until every element has been visited.
     * 
     * Explanation: The elements of the matrix are returned in the order they are visited in a 
     * clockwise spiral starting from the top left corner.
     * 
     * matrix = [
                    [0,1,2],
                    [3,4,5],
                    [6,7,8]
                ]
     * o/p = [0,1,2,5,8,7,6,3,4]
     * 
     * Approach:
     * 1. Initialize four pointers to represent the boundaries of the matrix: top, bottom, left, and right.
     *  like - top = 0, bottom = m-1, left = 0, right = n-1
     * 2. Use a while loop to traverse the matrix until the pointers meet.
     *  like - while (top <= bottom && left <= right)
     * 3. Traverse from left to right along the top boundary, then increment the top pointer.
     *  like - for (int i = left; i <= right; i++) result.add(matrix[top][i]);
     * 4. Traverse from top to bottom along the right boundary, then decrement the right pointer.
     *   like - for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
     * 5. Traverse from right to left along the bottom boundary, then decrement the bottom pointer.
     * 6. Traverse from bottom to top along the left boundary, then increment the left pointer.
     * 7. Repeat steps 3-6 until the pointers meet, ensuring that you check the boundaries before each 
     *    traversal to avoid duplicates.
     * 
     * 
     * Complexity:
     * Time complexity: O(m*n) - Each element of the matrix is visited once.
     * Elaborate on time complexity: The algorithm traverses each element of the matrix exactly once, 
     * resulting in a time complexity of O(m*n), where m is the number of rows and n is the number of columns in the matrix. The while loop ensures that we only traverse the necessary elements as we adjust the boundaries after each traversal.
     * 
     * Since there are 1 while and 4 for loops how is it O(m*n) and not O(4*m*n) or O(5*m*n) or mxn ^4?
     * The time complexity is O(m*n) because we are counting the number of operations in terms of the number 
     * of elements in the matrix. The constant factor (like 4 or 5) is ignored in Big O notation, 
     * as it does not affect the growth rate of the algorithm. Each element is processed a constant number 
     * of times (at most once), so the overall time complexity remains O(m*n).
     * 
     * Why its not ^4? 
     * The time complexity is not O((m*n)^4) because we are not performing a nested loop that iterates 
     * over the entire matrix four times. Instead, we are performing a single traversal of the matrix in a 
     * spiral manner, which results in each element being visited once. The four for loops are sequential 
     * and do not create a multiplicative effect on the number of operations, hence the time 
     * complexity is O(m*n) rather than O((m*n)^4).
     * 
     * 
     * Space complexity: O(m*n) - The output list contains all elements of the matrix
     */

    static List<Integer> spiralMatrix(int[][] matrix) {
        List<Integer> result = new java.util.ArrayList<>();
        
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1; //m-1 - rows
        int left = 0;
        int right = matrix[0].length - 1; //n-1 - columns

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) { // to avoid duplicates when there is only one row left
                // Traverse from right to left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) { // to avoid duplicates when there is only one column left 
                // Traverse from bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;   
        
    }

     public static void main (String[] args){
        int[][] matrix = { {0,1,2}, {3,4,5}, {6,7,8} };
        List<Integer> result = spiralMatrix(matrix);
        System.out.println(result); // Output: [0, 1, 2,

     }           
}
