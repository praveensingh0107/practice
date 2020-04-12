package intbit.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Max Sum Without Adjacent Elements
 * Asked in:
 * Epic systems
 * Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers
 * is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.
 *
 * Note: You can choose more than 2 numbers.
 *
 * Input Format:
 *
 * The first and the only argument of input contains a 2d matrix, A.
 * Output Format:
 *
 * Return an integer, representing the maximum possible sum.
 * Constraints:
 *
 * 1 <= N <= 20000
 * 1 <= A[i] <= 2000
 * Example:
 *
 * Input 1:
 *     A = [   [1]
 *             [2]    ]
 *
 * Output 1:
 *     2
 *
 * Explanation 1:
 *     We will choose 2.
 *
 * Input 2:
 *     A = [   [1, 2, 3, 4]
 *             [2, 3, 4, 5]    ]
 *
 * Output 2:
 *     We will choose 3 and 5.
 */
public class MaxSumWithoutAdjacentElement {
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        if (A == null || A.size() < 2 || A.get(0).size() == 0)
            return 0;
        int[] dp = new int[A.get(0).size() + 1];
        dp[1] = Math.max(A.get(0).get(0), A.get(1).get(0));
        for (int i = 2; i <= A.get(0).size(); i++) {
            int max = Math.max(A.get(0).get(i-1), A.get(1).get(i-1));
            dp[i] = Math.max(max + dp[i-2], dp[i-1]);
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        List<List<Integer>> l1 = List.of(List.of(1), List.of(2));
        ArrayList<ArrayList<Integer>> a1 = new ArrayList<>();
        l1.forEach(x -> a1.add(new ArrayList<>(x)));
        List<List<Integer>> l2 = List.of(List.of(1, 2, 3, 4), List.of(2, 3, 4, 5));
        ArrayList<ArrayList<Integer>> a2 = new ArrayList<>();
        l2.forEach(x -> a2.add(new ArrayList<>(x)));
        MaxSumWithoutAdjacentElement obj = new MaxSumWithoutAdjacentElement();
        System.out.println(a1);
        System.out.println(obj.adjacent(a1));
        System.out.println(a2);
        System.out.println(obj.adjacent(a2));
    }
}
