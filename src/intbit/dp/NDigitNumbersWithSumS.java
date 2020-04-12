package intbit.dp;

/**
 * N digit numbers with digit sum S
 * Find out the number of N digit numbers, whose digits on being added equals to a given number S. Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.
 *
 * Since the answer can be large, output answer modulo 1000000007
 *
 * **
 *
 * N = 2, S = 4
 * Valid numbers are {22, 31, 13, 40}
 * Hence output 4.
 *
 * Seen this question in a real interview beforeYesNo
 */
public class NDigitNumbersWithSumS {
    public int solveRec(int A, int B) {
        int mod = 1000000007;
        return (int)solveUtil(A, B, mod, true);
    }

    private long solveUtil(int a, int b, int mod, boolean isFirst) {
        if (a == 1 && b >= 0 && b <= 9)
            return 1;
        else if (a == 1 && (b <0 || b > 9))
            return 0;
        long res = 0;
        for (int i = isFirst?1:0; i <= 9; i++) {
            res = (res + solveUtil(a-1, b - i, mod, false)) % mod;
        }
        return res;
    }

    public int solve(int A, int B) {
        if (A == 1 && B >=1 && B <=9)
            return 1;
        else if (A == 1 && (B <0 || B > 9))
            return 0;
        int mod = 1000000007;
        int[][] dp = new int[A+1][B+1];
        for (int col = 1; col <= Math.min(9, B); col++)
            dp[1][col] = 1;
        for (int row = 2; row <= A; row++) {
            for (int col = 1; col <= B; col++) {
                long res = 0;
                for (int i = 0; i <= Math.min(9, col); i++) {
                    res += dp[row - 1][col - i];
                }
                dp[row][col] = (int)res%mod;
            }
        }
        return dp[A][B];
    }

    public int solveDP(int A, int B) {
        if (A == 1 && B >=1 && B <=9)
            return 1;
        else if (A == 1 && (B <0 || B > 9))
            return 0;
        int mod = 1000000007;
        int[][] dp = new int[2][B+1];
        for (int col = 1; col <= Math.min(9, B); col++)
            dp[1][col] = 1;
        for (int row = 2; row <= A; row++) {
            for (int col = 1; col <= B; col++) {
                long res = 0;
                for (int i = 0; i <= Math.min(9, col); i++) {
                    res = (res + dp[(row -1)%2][col - i])%mod;
                }
                dp[row%2][col] = (int)res;
            }
        }
        return dp[A%2][B];
    }


    public static void main(String[] args) {
        NDigitNumbersWithSumS obj = new NDigitNumbersWithSumS();
        /*System.out.println(obj.solveRec(2, 4));//4
        System.out.println(obj.solveRec(3, 21));// ans =28
        System.out.println(obj.solveRec(5, 21));// ans =5283*/
        //System.out.println(obj.solveRec(75, 22));
        System.out.println(obj.solve(2, 4));//4
        System.out.println(obj.solve(3, 21));// ans =28
        System.out.println(obj.solve(5, 21));// ans =5283
        System.out.println(obj.solve(75, 22));// ans =5283
        System.out.println(obj.solveDP(2, 4));//4
        System.out.println(obj.solveDP(3, 21));// ans =28
        System.out.println(obj.solveDP(5, 21));// ans =5283
        System.out.println(obj.solveDP(75, 22));// ans =5283
    }
}
