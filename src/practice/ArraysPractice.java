package practice;

import java.util.Scanner;

public class ArraysPractice {

    public static Integer[][] rotateMatrix(Integer[][] matrix) {
        if (matrix != null) {
            int row = matrix.length;
            int col = matrix[0].length;
            if (row == col) {
                int rotation = row / 2;
                for (int i = 0; i < rotation; i++) {
                    int start = i;
                    int end = col - i - 1;
                    int temp = matrix[i][i];
                    //left to right
                    for (int j = start + 1; j <= end; j++) {
                        temp = matrix[i][j];
                        matrix[i][j] = matrix[i][j - 1];

                    }
                    // for right to down
                    for (int j = start + 1; j <= end; j++) {
                        temp = matrix[end][j];
                        matrix[end][j] = matrix[end][j - 1];
                    }
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Integer[][] matrix = new Integer[4][4];
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\s");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
