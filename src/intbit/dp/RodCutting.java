package intbit.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Rod Cutting
 * Asked in:
 * Google
 * There is a rod of length N lying on x-axis with its left end at x = 0 and right end at x = N. Now, there are M weak points on this rod denoted by positive integer values(all less than N) A1, A2, …, AM. You have to cut rod at all these weak points. You can perform these cuts in any order. After a cut, rod gets divided into two smaller sub-rods. Cost of making a cut is the length of the sub-rod in which you are making a cut.
 * <p>
 * Your aim is to minimise this cost. Return an array denoting the sequence in which you will make cuts. If two different sequences of cuts give same cost, return the lexicographically smallest.
 * <p>
 * Notes:
 * <p>
 * Sequence a1, a2 ,…, an is lexicographically smaller than b1, b2 ,…, bm, if and only if at the first i where ai and bi differ, ai < bi, or if no such i found, then n < m.
 * N can be upto 109.
 * For example,
 * <p>
 * N = 6
 * A = [1, 2, 5]
 * <p>
 * If we make cuts in order [1, 2, 5], let us see what total cost would be.
 * For first cut, the length of rod is 6.
 * For second cut, the length of sub-rod in which we are making cut is 5(since we already have made a cut at 1).
 * For third cut, the length of sub-rod in which we are making cut is 4(since we already have made a cut at 2).
 * So, total cost is 6 + 5 + 4.
 * <p>
 * Cut order          | Sum of cost
 * (lexicographically | of each cut
 * sorted)           |
 * ___________________|_______________
 * [1, 2, 5]          | 6 + 5 + 4 = 15
 * [1, 5, 2]          | 6 + 5 + 4 = 15
 * [2, 1, 5]          | 6 + 2 + 4 = 12
 * [2, 5, 1]          | 6 + 4 + 2 = 12
 * [5, 1, 2]          | 6 + 5 + 4 = 15
 * [5, 2, 1]          | 6 + 5 + 2 = 13
 * <p>
 * <p>
 * So, we return [2, 1, 5].
 */
public class RodCutting {
    public ArrayList<Integer> rodCut(int A, List<Integer> B) {
        if (B == null || B.size() == 0)
            return new ArrayList<>(0);
        int n = B.size() + 2;
        int[] cuts = new int[n];
        cuts[0] = 0;
        for (int i = 0; i < B.size(); i++) {
            cuts[i + 1] = B.get(i);
        }
        cuts[n - 1] = A;
        long[][] dp = new long[n][n];
        int[][] parent = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int s = 0; s < n - len; s++) {
                int e = s + len;
                for (int k = s + 1; k < e; k++) {
                    long sum = cuts[e] - cuts[s] + dp[s][k] + dp[k][e];
                    if (dp[s][e] == 0 || sum < dp[s][e]) {
                        dp[s][e] = sum;
                        parent[s][e] = k;
                    }
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        backTrack(0, n - 1, res, cuts, parent);
        return res;
    }

    private void backTrack(int l, int r, ArrayList<Integer> result, int[] cuts, int[][] parent) {
        if (l + 1 >= r)
            return;
        result.add(cuts[parent[l][r]]);
        backTrack(l, parent[l][r], result, cuts, parent);
        backTrack(parent[l][r], r, result, cuts, parent);
    }

    public static void main(String[] args) {
        RodCutting obj = new RodCutting();
        List<Integer> B = List.of(1, 2, 5);
        System.out.println(obj.rodCut(6, List.of(1, 2, 5)));
        System.out.println(obj.rodCut(10, List.of(1, 3, 7, 9)));
        //System.out.println(obj.getMidIndex(B, 0, 6));
    }
}
