package intbit.dp;

/**
 * Edit Distance
 * Asked in:
 * Google
 * LinkedIn
 * Microsoft
 * Amazon
 * Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Input Format:
 *
 * The first argument of input contains a string, A.
 * The second argument of input contains a string, B.
 * Output Format:
 *
 * Return an integer, representing the minimum number of steps required.
 * Constraints:
 *
 * 1 <= length(A), length(B) <= 450
 * Examples:
 *
 * Input 1:
 *     A = "abad"
 *     B = "abac"
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     Operation 1: Replace d with c.
 *
 * Input 2:
 *     A = "Anshuman"
 *     B = "Antihuman"
 *
 * Output 2:
 *     2
 *
 * Explanation 2:
 *     => Operation 1: Replace s with t.
 *     => Operation 2: Insert i.
 */
public class EditDistance {
    public int minDistance(String A, String B) {
        if (A.length() > B.length()) {
            return minDistance(B, A);
        }
        return minDistance(A, 0, B, 0);
    }

    private int minDistance(String a, int i, String b, int j) {
        if (j == b.length() && i == a.length()) {
            return 0;
        }
        if (j == b.length() || i == a.length()) {
            return b.length() - i;
        }
        if (a.charAt(i) !=  b.charAt(j)) {
            return Math.min(minDistance(a, i + 1, b, j + 1), minDistance(a, i, b, j+1)) + 1;
        }
        return minDistance(a, i + 1, b, j + 1);
    }

    public int minDistanceDP(String A, String B) {
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 0; i <= A.length(); i++) {
            for (int j = 0; j <= B.length(); j ++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (A.charAt(i-1) == B.charAt(j - 1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[A.length()][B.length()];
    }

    public int minDistanceDPWithLessMemory(String A, String B) {
        int[][] dp = new int[2][B.length() + 1];
        //If string A is empty,
        for (int i = 0; i <= B.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 0; j <= B.length(); j ++) {
                //if string B is empty
                if (j == 0)
                    dp[i%2][j] = i;
                else if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i%2][j] = dp[(i-1)%2][j-1];
                } else {
                    dp[i%2][j] = Math.min(dp[(i-1)%2][j-1], Math.min(dp[(i-1)%2][j], dp[i%2][j-1])) + 1;
                }
            }
        }
        return dp[A.length()%2][B.length()];
    }

    public static void main(String[] args) {
        EditDistance obj = new EditDistance();
        System.out.println(obj.minDistance("abad", "abac"));
        System.out.println(obj.minDistance("Anshuman", "Antihuman"));
        System.out.println(obj.minDistance("", "Abc"));
        System.out.println(obj.minDistance("cxA", "Abc"));
        System.out.println(obj.minDistanceDP("abad", "abac"));
        System.out.println(obj.minDistanceDP("Anshuman", "Antihuman"));
        System.out.println(obj.minDistanceDP("", "Abc"));
        System.out.println(obj.minDistanceDP("cxA", "Abc"));
        System.out.println(obj.minDistanceDPWithLessMemory("abad", "abac"));
        System.out.println(obj.minDistanceDPWithLessMemory("Anshuman", "Antihuman"));
        System.out.println(obj.minDistanceDPWithLessMemory("", "Abc"));
        System.out.println(obj.minDistanceDPWithLessMemory("cxA", "Abc"));
    }
}
