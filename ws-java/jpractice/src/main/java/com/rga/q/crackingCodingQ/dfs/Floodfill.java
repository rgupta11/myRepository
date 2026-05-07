package com.rga.q.crackingCodingQ.dfs;

/**
 * DFS to solve flood fill problem:
 * Given a m x n integer grid image and integers sr, sc, and newColor, write a function to perform a flood fill on the image starting from the pixel image[sr][sc].

    In a 'flood fill', start by changing the color of image[sr][sc] to newColor. Then, change the color of all pixels connected to image[sr][sc] from either the top, bottom, left or right that have the same color as image[sr][sc], along with all the connected pixels of those pixels, and so on.

    Input:

    image = [[1,0,1],[1,0,0],[0,0,1]], sr = 1, sc = 1, color = 2
 * 
 * Output:

    [[1,2,1],[1,2,2],[0,0,1]]

    Time complexity: O(m*n) where m and n are the dimensions of the image, as in the worst case we may need to visit every pixel.
    Space complexity: O(m*n) in the worst case due to the recursion stack when all

 */
public class Floodfill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }

        int originalColor = image[sr][sc];
        if (originalColor == newColor) {
            return image;
        }

        fill(image, sr, sc, originalColor, newColor);
        return image;
    }

    private static void fill(int[][] image, int row, int col, int originalColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) {
            return;
        }
        if (image[row][col] != originalColor) {
            return;
        }

        image[row][col] = newColor;

        fill(image, row - 1, col, originalColor, newColor);
        fill(image, row + 1, col, originalColor, newColor);
        fill(image, row, col - 1, originalColor, newColor);
        fill(image, row, col + 1, originalColor, newColor);
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 0, 1},
                {1, 0, 0},
                {0, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        int[][] result = floodFill(image, sr, sc, newColor);
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
