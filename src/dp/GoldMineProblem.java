package dp;

/**
 * Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer
 * which is the amount of gold in tons. Initially the miner is at first column but can be at any row.
 * He can move only (right->,right up /,right down\) that is from a given cell,
 * the miner can move to the cell diagonally up towards the right or right or
 * diagonally down towards the right. Find out maximum amount of gold he can collect.
 *
 * Examples:
 *
 * Input : mat[][] = {{1, 3, 3},
 *                    {2, 1, 4},
 *                   {0, 6, 4}};
 * Output : 12
 * {(1,0)->(2,1)->(2,2)}
 */
public class GoldMineProblem {

    public int getMaxGold(int[][] goldMine) {
        if (goldMine == null || goldMine.length == 0) return 0;
        int n = goldMine.length;
        int m = goldMine[0].length;
        int[][] dp = new int[n][m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n ; i++) {
                int left_up = (j == 0) || (i == 0)? 0 : dp[i-1][j-1];
                int left = (j == 0)? 0 : dp[i][j-1];
                int left_down = (j == 0) || (i+1 == n) ? 0 : dp[i+1][j-1];
                dp[i][j] = goldMine[i][j] + Math.max(left, Math.max(left_up, left_down));
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i][m-1]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] goldMine = {{1, 3, 3}, {2, 1, 4}, {0, 6, 4}};
        GoldMineProblem obj = new GoldMineProblem();
        System.out.println(obj.getMaxGold(goldMine));
        int[][] mat = {{10, 33, 13, 15},
                        {22, 21, 04, 1},
                        {5, 0, 2, 3},
                        {0, 6, 14, 2}};
        System.out.println(obj.getMaxGold(mat));
    }
}
