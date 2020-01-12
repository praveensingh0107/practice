package intbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * N Queens: Example 1
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * <p>
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
public class NQueens {

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        Integer[] arr = new Integer[a];
        Arrays.fill(arr, -1);
        solveNQueens(res, arr, 0, a);
        return res;
    }

    private void solveNQueens(ArrayList<ArrayList<String>> results, Integer[] arr, int row, int a) {
        if (row == a) {
            ArrayList<String> result = new ArrayList<>();
            IntStream.range(0, a).forEach(i -> {
                StringBuilder sb = new StringBuilder();
                IntStream.range(0, a).forEach(x -> sb.append(arr[i] == x? "Q" : "."));
                result.add(sb.toString());
            });
            results.add(result);
        } else {
            IntStream.range(0, a).forEach(j -> {
                arr[row] = j;
                if (isSafe(arr, row)) {
                    solveNQueens(results, arr, row + 1, a);
                }
            });
        }
    }

    private boolean isSafe(Integer[] arr, int row) {
        boolean b = IntStream.range(0, row)
                .anyMatch(x -> arr[x] == arr[row] || Math.abs(arr[x] - arr[row]) == row - x);
        return !b;
    }

    public static void main(String[] args) {
        NQueens obj = new NQueens();
        System.out.println(obj.solveNQueens(4));
    }
}
