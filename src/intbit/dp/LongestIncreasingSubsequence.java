package intbit.dp;

import java.util.Arrays;
import java.util.List;

/**
 * Longest Increasing Subsequence
 * Asked in:
 * Facebook
 * Yahoo
 * Epic systems
 * Amazon
 * Microsoft
 * Find the longest increasing subsequence of a given array of integers, A.
 * <p>
 * In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as possible.
 * This subsequence is not necessarily contiguous, or unique.
 * In this case, we only care about the length of the longest increasing subsequence.
 * <p>
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument is an integer array A.
 * Output Format:
 * <p>
 * Return an integer representing the length of the longest increasing subsequence.
 * Constraints:
 * <p>
 * 1 <= length(A) <= 2500
 * 1 <= A[i] <= 2000
 * Example :
 * <p>
 * Input 1:
 * A = [1, 2, 1, 5]
 * <p>
 * Output 1:
 * 3
 * <p>
 * Explanation 1:
 * The sequence : [1, 2, 5]
 * <p>
 * Input 2:
 * A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
 * <p>
 * Output 2:
 * 6
 * <p>
 * Explanation 2:
 * The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
 */
public class LongestIncreasingSubsequence {

    public int lis(final List<Integer> A) {
        if (A == null || A.isEmpty())
            return 0;
        int[] dp = new int[A.size()];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(j) < A.get(i)) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        System.out.println(obj.lis(List.of(1, 2, 1, 5)));
        System.out.println(obj.lis(List.of(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)));
    }
}
