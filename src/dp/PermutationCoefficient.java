package dp;

public class PermutationCoefficient {

    public int permutationCoefficient(int n, int k) {
        if (n < 0 || k < 0 || n < k)
            return 0;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + j*dp[i-1][j-1];
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        PermutationCoefficient obj = new PermutationCoefficient();
        System.out.println(obj.permutationCoefficient(10,0));
        System.out.println(obj.permutationCoefficient(10,1));
        System.out.println(obj.permutationCoefficient(10,2));
        System.out.println(obj.permutationCoefficient(10,3));
        System.out.println(obj.permutationCoefficient(0,3));
        System.out.println(obj.permutationCoefficient(0,0));
        System.out.println(obj.permutationCoefficient(1,0));
        System.out.println(obj.permutationCoefficient(1,2));
    }
}
