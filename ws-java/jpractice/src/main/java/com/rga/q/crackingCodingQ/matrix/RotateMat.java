package com.rga.q.matrix;

public class RotateMat {
    /**
     * Write a function to rotate an n x n 2D matrix representing an image by 90 degrees clockwise. 
     * The rotation must be done in-place, meaning you should modify the input matrix directly without 
     * using an additional matrix for the operation.
     * 
     * matrix = [
                [1,4,7],
                [2,5,8],
                [3,6,9]
            ]
     * 
     * [
            [3,2,1],
            [6,5,4],
            [9,8,7]
        ]
     *
     * Approach:
     * 1. Transpose the matrix: Swap the elements at positions (i, j) and (j, i) for all i and j.
     * 2. Reverse each row: For each row in the transposed matrix, reverse the order of the elements to achieve the 90-degree clockwise rotation.
     * 
     * Complexity:
     * Time complexity: O(n^2) - Both the transposition and row reversal steps require iterating through 
     * the entire matrix, which has n^2 elements.
     * Space complexity: O(1) - The rotation is performed in-place, so no additional space is used beyond 
     * a few temporary variables for swapping.
     * 
     * 
     * 
     */
}
