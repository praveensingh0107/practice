package practice;

import java.util.ArrayList;
import java.util.List;

public class AllSubMatrixOfGivenMatrix {
    /*public static void printSubMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                for (int k = 0; k <= (n-i); k++) {
                    for (int p = 0; p <= (m-j); p++) {
                        System.out.print(matrix[k][p] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }*/

    public static void printSubMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int numRow = 1; numRow <= n; numRow++) {
            System.out.println("[");
            for (int numCol = 1; numCol <= m; numCol++) {
                System.out.println("(");
                for (int startRowIndex = 0; startRowIndex <= (n - numRow); startRowIndex++) {
                    //System.out.print("{");
                    for (int startColIndex = 0; startColIndex <= (m - numCol); startColIndex++) {
                        //System.out.print(matrix[k][p] + " ");
                        printSubMatrix(matrix, numRow, numCol, startRowIndex, startColIndex);
                    }
                    //System.out.println("},");
                }
                System.out.println("),");
            }
            System.out.println("]");
        }
    }

    private static void printSubMatrix(int[][] matrix, int numRow, int numCol, int startRowIndex,
            int startColIndex) {
        System.out.println("numRow: " + numRow + ", numCol: " + numCol);
        for (int r = startRowIndex, rowCount = 1; rowCount <= numRow; rowCount++, r++) {
            System.out.print("{ ");
            for (int c = startColIndex, colCount = 1; colCount <= numCol; colCount++, c++) {
                System.out.print(matrix[r][c] + ", ");
            }
            System.out.println(" }");
        }
    }

    public static int countOfSubMatricesWithSumZero(ArrayList<ArrayList<Integer>> A) {
        if (A == null || A.size() == 0 || A.get(0).size() == 0)
            return 0;
        int maxRowsCount = A.size();
        int maxColsCount = A.get(0).size();
        int count = 0;
        for (int rowsCount = 1; rowsCount <= maxRowsCount; rowsCount++) {
            for (int colsCount = 1; colsCount <= maxColsCount; colsCount++) {
                for (int startRowIndex = 0;
                     startRowIndex <= (maxRowsCount - rowsCount); startRowIndex++) {
                    for (int startColIndex = 0;
                         startColIndex <= (maxColsCount - colsCount); startColIndex++) {
                        if (countOfSubMatricesWithSumZero(A, rowsCount, colsCount, startRowIndex,
                                startColIndex) == 0)
                            count++;
                    }
                }
            }
        }
        return count;
    }

    private static int countOfSubMatricesWithSumZero(ArrayList<ArrayList<Integer>> A, int rowsCount,
            int colsCount, int startRowIndex, int startColIndex) {
        int sum = 0;
        for (int r = startRowIndex, rowCount = 1; rowCount <= rowsCount; rowCount++, r++) {
            for (int c = startColIndex, colCount = 1; colCount <= colsCount; colCount++, c++) {
                sum += A.get(r).get(c);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //printSubMatrix(matrix);
        int[][] matrix1 = {{-8, 5, 7}, {3, 7, -8}, {5, -8, 9}};
        List<List<Integer>> lists = List
                .of(List.of(-8, 5, 7), List.of(3, 7, -8), List.of(5, -8, 9));
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        lists.forEach(x -> A.add(new ArrayList<>(x)));
        //System.out.println(A);
        System.out.println(countOfSubMatricesWithSumZero(A));
    }
}
