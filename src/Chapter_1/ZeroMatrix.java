/*
    Muhammed Sabri Sahin
    12-Jan-19
    Chapter_1

    Cracking the Coding Interview - Question 1.8
*/
package Chapter_1;

import java.util.Scanner;

class ZeroMatrix {

    static int[][] matrix;
    static boolean[][] zeros;
    private static int rowCount;
    private static int colCount;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        rowCount = sc.nextInt();
        colCount = sc.nextInt();
        zeros = new boolean[rowCount][colCount];
        matrix = new int[rowCount][colCount];
        readMatrix();
        zeroMatrix();
    }

    private static void zeroMatrix() {
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                if(zeros[i][j]) zeroify(i, j);
            }
        }

        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void zeroify(int row, int col) {
        for(int i = 0; i < rowCount; i++) matrix[i][col] = 0;
        for(int j = 0; j < colCount; j++) matrix[row][j] = 0;
    }

    private static void readMatrix() {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                matrix[i][j] = sc.nextInt();
                if(matrix[i][j] == 0) zeros[i][j] = true;
            }
        }
    }
}
