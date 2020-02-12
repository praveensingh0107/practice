package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CoinChange {

    //wrong solution, changes based on coin order
    public static int coinChangeUsingRecursion(int[] denom, int val, String prefix,
            List<String> result, int startIndex) {
        if (val == 0) {
            result.add(prefix);
            return 1;
        }
        int res = 0;
        for (int i = startIndex; i < denom.length; i++) {
            int remainder = val - denom[i];
            if (remainder >= 0) {
                res += coinChangeUsingRecursion(denom, remainder, prefix + "," + denom[i], result,
                        i);
            }
        }
        return res;
    }

    public static int coinChange(int[] denom, int index, int val, String prefix,
            List<String> result) {
        if (val == 0) {
            result.add(prefix);
            return 1;
        }
        if (val < 0 || index < 0)
            return 0;

        if (denom[index] > val) {
            return coinChange(denom, index - 1, val, prefix, result);
        } else {
            return coinChange(denom, index, val - denom[index], prefix + "," + denom[index], result)
                    + coinChange(denom, index - 1, val, prefix, result);
        }
    }

    public static int coinChangeDP(int[] denom, int val) {
        int m = denom.length;
        int[][] dp = new int[val+1][m+1];
        IntStream.range(0, m+1).forEach(x -> dp[0][x] = 1);
        for (int i = 1; i <= val; i++) {
            for (int j = 1; j <= m; j++) {
                if (denom[j-1] > i)
                    dp[i][j] = dp[i][j-1];
                else
                    dp[i][j] = dp[i][j-1] + dp[i-denom[j-1]][j];
            }
        }
        return dp[val][m];
    }

    public static void main(String[] args) {
        int[] denom = new int[] {2, 1, 3};
        int val = 4;
        List<String> result = new ArrayList<>();
        System.out.println(coinChangeUsingRecursion(denom, val, "", result, 0));
        System.out.println(result);
        result.clear();
        System.out.println(coinChange(denom, denom.length - 1, val, "", result));
        System.out.println(result);
        System.out.println(coinChangeDP(denom, val));

    }

}
