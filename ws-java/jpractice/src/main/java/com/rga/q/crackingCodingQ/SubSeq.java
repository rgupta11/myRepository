package com.rga.q.crackingCodingQ;


/**
 * String s and word[]. Find the no of subsequence which exist in S
 * s=abcdea
 * w[a, bb, bcd, ace]
 * count =3 [a, bcd, ace] 
 * Order should be considered
 * 
 * Approach 1 - Brute force calculate all subseq of String S and then compare with word[]
 * It with 2^n order. [n-> size of S and S is string]
 * 
 * Approach 2
 *  -Precompute location of letter to index
 *      -hashMap [a-0,5, b-1, c-2, d-3, e-4]
 *  -Loop over word[]
 *      - for each word get the seq from lookup
 *          - a - all words should exist & seq of positions should be increasing i.e. no seq with 032 
 * 
 * - Time complexity: O(len(S) + sum of lengths of words in word[])
 *      O(n+m)
 * - Space complexity: O(n)
 * 
 * https://www.youtube.com/watch?v=Ebyesd3mPAA
 */ 

public class SubSeq {


    
}
