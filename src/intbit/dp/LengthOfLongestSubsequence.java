package intbit.dp;

import java.util.Arrays;
import java.util.List;

/**
 * Length of Longest Subsequence
 * Asked in:
 * Microsoft
 * Problem Setter: mayank111 Problem Tester: glowing_glare
 * Given an array of integers, A of length N, find the length of longest subsequence which is first increasing then decreasing.
 *
 * Input Format:
 *
 * The first and the only argument contains an integer array, A.
 * Output Format:
 *
 * Return an integer representing the answer as described in the problem statement.
 * Constraints:
 *
 * 1 <= N <= 3000
 * 1 <= A[i] <= 1e7
 * Example:
 *
 * Input 1:
 *     A = [1, 2, 1]
 *
 * Output 1:
 *     3
 *
 * Explanation 1:
 *     [1, 2, 1] is the longest subsequence.
 *
 * Input 2:
 *     [1, 11, 2, 10, 4, 5, 2, 1]
 *
 * Output 2:
 *     6
 *
 * Explanation 2:
 *     [1 2 10 4 2 1] is the longest subsequence.
 */
public class LengthOfLongestSubsequence {
    public int longestSubsequenceLength(final List<Integer> A) {
        if (A.size() == 0) return 0;
        int[] increasingSubsequence = getIncreasingSubsequence(A);
        int[] decreasingSubsequence = getDecreasingSubsequence(A);
        int sum = 0;
        for(int i = 0; i < A.size(); i++) {
            sum = Math.max(sum, increasingSubsequence[i] + decreasingSubsequence[i]);
        }
        return sum -1;
    }

    private int[] getDecreasingSubsequence(List<Integer> a) {
        int[] subsequence = new int[a.size()];
        Arrays.fill(subsequence, 1);
        for (int i = a.size() -2; i >= 0; i--) {
            int max = 0;
            for (int j = a.size() -1; j > i; j--) {
                if (a.get(i) > a.get(j))
                    max = Math.max(max, subsequence[j]);
            }
            subsequence[i] = max + 1;
        }
        return subsequence;
    }

    private int[] getIncreasingSubsequence(List<Integer> a) {
        int[] subsequence = new int[a.size()];
        Arrays.fill(subsequence, 1);
        for (int i = 1; i < a.size(); i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (a.get(i) > a.get(j))
                    max = Math.max(max, subsequence[j]);
            }
            subsequence[i] = max + 1;
        }
        return subsequence;
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 11, 2, 10, 4, 5, 2, 1);
        LengthOfLongestSubsequence obj = new LengthOfLongestSubsequence();
        System.out.println(obj.longestSubsequenceLength(list1));
        List<Integer> list2 = List.of(1, 2, 1);
        System.out.println(obj.longestSubsequenceLength(list2));
    }
}
