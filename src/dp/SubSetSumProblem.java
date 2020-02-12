package dp;

import java.util.stream.IntStream;

/**
 * Given a set of non-negative integers, and a value sum,
 * determine if there is a subset of the given set with sum equal to given sum.
 * Example:
 *
 * Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output:  True  //There is a subset (4, 5) with sum 9.
 */
public class SubSetSumProblem {

    public boolean isSubsetSum(int set[], int sum) {
        int n = set.length;
        boolean[][] dp = new boolean[sum + 1][n + 1];
        IntStream.range(0, n+1).forEach(i -> dp[0][i] = true);
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1];
                if (i >= set[j-1])
                    dp[i][j] |= dp[i-set[j-1]][j-1];
            }
        }
        return dp[sum][n];
    }

    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        SubSetSumProblem obj = new SubSetSumProblem();
        System.out.println(obj.isSubsetSum(set, sum));
        System.out.println(obj.isSubsetSum(set, 1));
        System.out.println(obj.isSubsetSum(set, 2));
        System.out.println(obj.isSubsetSum(set, 13));
    }
}
