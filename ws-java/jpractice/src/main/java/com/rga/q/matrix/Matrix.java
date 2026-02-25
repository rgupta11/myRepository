package com.rga.q.matrix;

public class Matrix {
    
    public static int[][] createMat(int r, int c){
        int[][] mat = new int [r][c];
        for(int i=1; i<=r; i++){
            for (int j=1; j<=c; j++){
                mat[i][j] = i+j;
            }

        }
        return mat;
    }

    public static void printMat(int [][] mat){

        //todo
    }

    /**
     * 
     * @param args
     * 
     * Brute force 
     *  3 nested loops - O(n^3)
     * 
     *  c11 = a11 x b11 + a12 x b21
     *  c12 =
     *  c21 =
     *  c22 =
     */
    public static int[][] matMutltiplyBruteForce(int[][] mat1, int r1, int c1, int[][] mat2, int r2, int c2){
        
        int [][] newMat = new int[r1][c2]; 
        for (int i=0; i<r1; i++){
            for(int j=0; j<c2; j++){
                for (int k=0; k<r1; k++) {
                    newMat[i][j] = 0;
                    newMat[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return newMat;
    }

    /**
     * 
     * We use divide and conquer 
     * Assuming matrices are in power of 2 like 2x2, 4x4, 8x8, 16x16....
     * 2x2 is smallest matrix which can be multipled 
     * And each 2x2 is can be acheived by formula than 3 nested loops
     *  c11 = a11 x b11 + a12 x b21
     *  c12 = a11 x b12 + a12 x b22
     *  c21 = a21 x b11 + a22 x b21
     *  c22 = a21 x b12 + a22 x b22
     * 
     * If its not in power of 2 then fill sub matrix to 0
     * 
     * recurrance solution for 4x4 
     * rec - 8 times
     * t(n) = [ 8 times t(n/2) + addition of matrix are not scalar but matrix addn so n^2]
     * t(n) = [ t(n/2) + n^2] = (n^2)
     * 
     * .... n^3 is also n^3
     * 
     * so algo with 3 for is better than this as this uses more memory
     */
    public static int[][] matMutltiply(int[][] mat1, int[][] mat2, int n){
        int [][] newMat = new int[n][n]; 

        if(n<=2){
            //just solve by 4 formulas
        }else{
            //divide recursively
            n = n/2; //mid .. n/2
            
            //matMutltiply (a11, b11, n/2) + matMutltiply (a12, b21, n/2);
            //matMutltiply (a11, b12, n/2) + matMutltiply (a12, b22, n/2);
            //matMutltiply (a21, b11, n/2) + matMutltiply (a22, b21, n/2);
            //matMutltiply (a21, b12, n/2) + matMutltiply (a22, b22, n/2);
        }
        return newMat;
    }

    //Strasen's mat multiplication
    /**
     * In older algo 4 formaulas made 8 multiplication and 4 additions 
     * Strasen reduced to 7 mult 
     * 
     * c11=
     * c12=
     * c21=
     * c22=
     * 
     */



    //Multiplication
    //Rotation of matrix
    public static void main(String[] args) {
        

        /** 
         * Multiplication of 2 matrix
         * mxn nxk col of M1 = row of M2
         * Resultant = mxk
         * Brute force 
         *  3 nested loops - O(n^3)
         * 
         */

        

 
    }
}
