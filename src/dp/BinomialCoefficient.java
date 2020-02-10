package dp;

public class BinomialCoefficient {

    public int binomialCoefficient(int n, int k) {
        if (n < 0 || k < 0 || n < k) return 0;
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0|| i == j)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        BinomialCoefficient obj = new BinomialCoefficient();
        System.out.println(obj.binomialCoefficient(4, 2));
    }
}
