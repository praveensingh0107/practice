package intbit.dp;

import java.util.List;

/**
 * Best Time to Buy and Sell Stocks I Asked in: Amazon Facebook Problem Description
 * Say you have an array, A, for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit. Return the maximum possible profit.
 * Problem Constraints
 * 0 <= len(A) <= 7e5
 * 1 <= A[i] <= 1e7
 * Input Format
 * The first and the only argument is an array of integers, A.
 * Output Format
 * Return an integer, representing the maximum possible profit.
 * Example Input
 * Input 1:
 * A = [1, 2] Input 2: A = [1, 4, 5, 2, 4]
 * Example Output
 * Output 1:
 * 1 Output 2: 4
 * Example Explanation
 * Explanation 1:
 * Buy the stock on day 0, and sell it on day 1. Explanation 2: Buy the stock on day 0, and sell it on day 2.
 */
public class BestTimeToBuyAndSellStock1 {
    public int maxProfit(final List<Integer> A) {
        if (A == null || A.isEmpty() || A.size() == 1)
            return 0;
        int minVal = A.get(0);
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < A.size(); i++) {
            minVal = Math.min(minVal, A.get(i));
            maxProfit = Math.max(maxProfit, A.get(i) - minVal);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock1 obj = new BestTimeToBuyAndSellStock1();
        System.out.println(obj.maxProfit(List.of(5, 1, 3, 7, 6, 8, 5, 7)));
    }
}
