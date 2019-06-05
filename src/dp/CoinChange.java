package dp;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        int[] denom = new int[] {2, 1, 3};
        int val = 4;
        List<String> result = new ArrayList<>();
        System.out.println(coinChangeUsingRecursion(denom, val, "", result, 0));
        System.out.println(result);
        result.clear();
        System.out.println(coinChange(denom, denom.length - 1, val, "", result));
        System.out.println(result);

    }

}
