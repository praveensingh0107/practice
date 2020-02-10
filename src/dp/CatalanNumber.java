package dp;

public class CatalanNumber {

    public int catalanNumber(int n) {
        if (n < 0)
            return 0;
        else if (n < 2)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        CatalanNumber obj = new CatalanNumber();
        System.out.println(obj.catalanNumber(5));
    }
}
