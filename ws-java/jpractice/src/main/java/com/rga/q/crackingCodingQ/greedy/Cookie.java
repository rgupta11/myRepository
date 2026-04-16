package com.rga.q.crackingCodingQ.greedy;


import java.util.Arrays;

/**
 * Greedy cookie problem: You have a bag of cookies, and children with cookie greedness.
 * Example:
 * Input: cookies = [1, 2, 3], greed = [1, 1]
 * Output: 2
 * Explanation: You have 3 cookies and 2 children. The greed of 1st child is 1, and the greed of 2nd child is 1. You can give
 * Output: 1
 * 
 * Input: cookies = [1, 2], greed = [1, 2, 3]
 * Output: 2
 * Explanation: You have 2 cookies and 3 children. The greed of 1st child is 1, the greed of 2nd child is 2, and the greed of
 * 
 * Approach: Sort the cookies and greed arrays. Use two pointers, one for cookies and one for greed. Iterate through both arrays and count how many children can be satisfied with the available cookies.
 * 1. Sort the cookies and greed arrays in non-decreasing order.
 * 2. Initialize two pointers, one for cookies (cookieIndex) and one for greed (greedIndex), and a count variable to keep track of satisfied children.
 * 3. While both pointers are within the bounds of their respective arrays:
 *    a. If the current cookie can satisfy the current child's greed (cookies[cookieIndex] >= greed[greedIndex]), increment the count of satisfied children and move both pointers to the next cookie and the next child.
 * 
 * 
 * Time complexity: O(n log n + m log m) where n is the number of cookies and m is the number 
 * of children, due to the sorting step. The iteration step is O(n + m).
 * 
 * if n=m, then time complexity is O(n log n) else it will be O(n log n + m log m)
 * which is from sorting .
 * 
 * Also O(n log n + m log m) + O(n+m) [iteration]
 * Because in Big-O, we keep only the dominant (fastest-growing) terms.
 * So  O(n+m) is dominated by O(n log n + m log m) and can be omitted
 * 
 * 
 */
public class Cookie {
   
    public static int cookieGreed(int[] cookies, int[] greed){

        // Step 1: Sort the cookies and greed arrays
        Arrays.sort(cookies);
        Arrays.sort(greed); 
        //Time complexity of sorting is O(n log n)


        int cookieIndex = 0; // Pointer for cookies
        int greedIndex = 0; // Pointer for greed
        int satisfiedChildren = 0; // Count of satisfied children

        // Step 2: Iterate through both arrays
        while (cookieIndex < cookies.length && greedIndex < greed.length) {
            if (cookies[cookieIndex] >= greed[greedIndex]) {
                // If the current cookie can satisfy the current child's greed
                satisfiedChildren++;
                cookieIndex++; // Move to the next cookie
                greedIndex++; // Move to the next child
            } else {
                cookieIndex++; // Move to the next cookie to find a bigger one
            }
        }

        return satisfiedChildren;   

    }


    public static void main(String[] args) {
        int[] cookies = {1, 2, 3};
        int[] greed = {1, 1};
        System.out.println(cookieGreed(cookies, greed)); // Output: 2 

    }

}
