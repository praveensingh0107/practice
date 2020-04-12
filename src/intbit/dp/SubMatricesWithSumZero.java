package intbit.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Sub Matrices with sum Zero
 * Asked in:
 * Google
 * Problem Setter: mihai.gheorghe Problem Tester: sneh_gupta
 * Given a 2D matrix, find the number non-empty sub matrices, such that the sum of the elements inside the sub matrix is equal to 0. (note: elements might be negative).
 *
 * Example:
 *
 * Input
 *
 * -8 5  7
 * 3  7 -8
 * 5 -8  9
 * Output
 * 2
 *
 * Explanation
 * -8 5 7
 * 3 7 -8
 * 5 -8 9
 *
 * -8 5 7
 * 3 7 -8
 * 5 -8 9
 */
public class SubMatricesWithSumZero {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        if (A == null || A.size() == 0 || A.get(0).size() == 0)
            return 0;
        int n = A.size();
        int m = A.get(0).size();
        int[][] sum = new int[n][m];
        // populate sum
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                sum[r][c] = A.get(r).get(c);
            }
        }

        // process cols
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < m ; c++) {
                sum[r][c] += sum[r-1][c];
            }
        }
        //process rows
        for (int c = 1; c < m; c++) {
            for (int r = 0; r < n; r++) {
                sum[r][c] += sum[r][c-1];
            }
        }

        int count = 0;
        for (int rowCount = 0; rowCount < n; rowCount++) {
            for (int colCount = 0; colCount <m; colCount++) {
                for (int startRowIndex = 0; startRowIndex < (n - rowCount); startRowIndex++) {
                    for (int startColIndex = 0; startColIndex < (m - colCount); startColIndex++) {
                        if (sumOfSubMetrix(sum,startRowIndex, startColIndex, rowCount, colCount) == 0)
                            count++;
                    }
                }
            }
        }
        return count;
    }

    public int solve1(ArrayList<ArrayList<Integer>> A) {
        if (A == null || A.size() == 0 || A.get(0).size() == 0)
            return 0;
        int n = A.size();
        int m = A.get(0).size();
        int[][] sum = new int[n + 1][m + 1];
        // populate sum
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                sum[r][c] = A.get(r-1).get(c-1)  + sum[r-1][c] + sum[r][c-1] - sum[r-1][c-1];
            }
        }
        int count = 0;
        for (int rowCount = 0; rowCount < n; rowCount++) {
            for (int colCount = 0; colCount <m; colCount++) {
                for (int startRowIndex = 1; startRowIndex <= (n - rowCount); startRowIndex++) {
                    for (int startColIndex = 1; startColIndex <= (m - colCount); startColIndex++) {
                        if (sumOfSubMetrix(sum,startRowIndex, startColIndex, rowCount, colCount) == 0)
                            count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Sum of subMatrix[[i, j],[i+x, j + y]] = sumMatrix[i + x][j + y] - sum[i-1][j + y] - sum[i+x][j-1] + sum[i-1][j-1]
     * @param sumMatrix
     * @param i
     * @param j
     * @param x
     * @param y
     * @return
     */
    private int sumOfSubMetrix(int[][] sumMatrix, int i , int j, int x,
            int y) {
        return sumMatrix[i+x][j + y] - sumMatrix[i-1][j + y] - sumMatrix[i+x][j-1]+ sumMatrix[i-1][j-1];
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = List
                .of(List.of(-8, 5, 7), List.of(3, 7, -8), List.of(5, -8, 9));
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        lists.forEach(x -> A.add(new ArrayList<>(x)));
        SubMatricesWithSumZero obj = new SubMatricesWithSumZero();
        System.out.println(obj.solve1(A));
    }
}
