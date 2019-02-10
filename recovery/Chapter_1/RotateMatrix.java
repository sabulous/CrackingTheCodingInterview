/*
    Muhammed Sabri Sahin
    12-Jan-19
    Chapter_1

    Cracking the Coding Interview - Question 1.7
*/
package Chapter_1;

import java.util.Scanner;

public class RotateMatrix {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        rotate(matrix);
    }

    private static boolean rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int n = matrix.length;
        for(int row = 0 ; row < n/2; row++) {
            for(int col = row; col < n-row-1; col++) {
                int top = matrix[row][col]; // keep temp top as it will be overwritten.

                // left to top
                matrix[row][col] = matrix[n-col-1][row];

                //bot to left
                matrix[n-col-1][row] = matrix[n-row-1][n-col-1];

                //right to bot
                matrix[n-row-1][n-col-1] = matrix[col][n-row-1];

                // top to right
                matrix[col][n-row-1] = top;
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        return true;
    }
}
