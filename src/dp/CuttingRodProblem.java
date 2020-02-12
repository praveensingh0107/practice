package dp;

/**
 * Cutting a Rod | DP-13
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example,
 * if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 *
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 */
public class CuttingRodProblem {

    public int cutRod(int[] prices, int size) {
        int[] dp = new int[size + 1];
        dp[0] = 0;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], prices[j-1] + dp[i-j]);
            }
        }
        return dp[size];
    }

    public static void main(String[] args) {
        CuttingRodProblem obj = new CuttingRodProblem();
        int prices[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = prices.length;
        System.out.println(obj.cutRod(prices, 8));
    }
}
