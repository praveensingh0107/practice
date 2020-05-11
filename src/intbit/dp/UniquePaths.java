package intbit.dp;

import java.util.List;

/**
 * Unique Paths in a Grid
 * Asked in:
 * Facebook
 * Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Example :
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p>
 * Note: m and n will be at most 100.
 */
public class UniquePaths {
    public int uniquePathsWithObstaclesRec(List<List<Integer>> A) {
        if (A == null || A.isEmpty())
            return 0;
        int m = A.size();
        int n = A.get(0).size();
        return uniquePathsWithObstaclesRec(A, m - 1, n - 1);
    }

    private int uniquePathsWithObstaclesRec(List<List<Integer>> A, int m, int n) {
        if (m == 0 && n == 0)
            return 1;
        if (m < 0 || n < 0)
            return 0;
        if (A.get(m).get(n) == 1)
            return 0;
        return uniquePathsWithObstaclesRec(A, m - 1, n) + uniquePathsWithObstaclesRec(A, m, n - 1);
    }

    public int uniquePathsWithObstacles(List<List<Integer>> A) {
        if (A == null || A.isEmpty())
            return 0;
        int m = A.size();
        int n = A.get(0).size();
        int[][] dp = new int[m + 1][n + 1];
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                if (r == 1 && c == 1) {
                    dp[r][c] = A.get(r - 1).get(c - 1) == 1 ? 0 : 1;
                } else if (A.get(r - 1).get(c - 1) == 1)
                    dp[r][c] = 0;
                else
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        UniquePaths obj = new UniquePaths();
        List<List<Integer>> lists = List.of(List.of(0, 0, 0), List.of(0, 1, 0), List.of(0, 0, 0));
        System.out.println(obj.uniquePathsWithObstaclesRec(lists));
        System.out.println(obj.uniquePathsWithObstacles(lists));
    }
}
