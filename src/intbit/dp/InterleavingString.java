package intbit.dp;

/**
 * Interleaving Strings
 * Asked in:
 * Google
 * Yahoo
 * Given A, B, C, find whether C is formed by the interleaving of A and B.
 * <p>
 * Input Format:*
 * <p>
 * The first argument of input contains a string, A.
 * The second argument of input contains a string, B.
 * The third argument of input contains a string, C.
 * Output Format:
 * <p>
 * Return an integer, 0 or 1:
 * => 0 : False
 * => 1 : True
 * Constraints:
 * <p>
 * 1 <= length(A), length(B), length(C) <= 150
 * Examples:
 * <p>
 * Input 1:
 * A = "aabcc"
 * B = "dbbca"
 * C = "aadbbcbcac"
 * <p>
 * Output 1:
 * 1
 * <p>
 * Explanation 1:
 * "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)
 * <p>
 * Input 2:
 * A = "aabcc"
 * B = "dbbca"
 * C = "aadbbbaccc"
 * <p>
 * Output 2:
 * 0
 * <p>
 * Explanation 2:
 * It is not possible to get C by interleaving A and B.
 */
public class InterleavingString {
    public int isInterleaveRec(String A, String B, String C) {
        if (A == null || B == null || C == null)
            return 0;
        if (A.length() + B.length() != C.length())
            return 0;
        return isInterleaveRec(A, A.length() - 1, B, B.length() - 1, C, C.length() - 1) ? 1 : 0;
    }

    private boolean isInterleaveRec(String A, int i, String B, int j, String C, int k) {
        if (i == -1 && j == -1 && k == -1)
            return true;
        if (i >= 0 && A.charAt(i) == C.charAt(k)) {
            if (isInterleaveRec(A, i - 1, B, j, C, k - 1))
                return true;
        }
        if (j >= 0 && B.charAt(j) == C.charAt(k)) {
            if (isInterleaveRec(A, i, B, j - 1, C, k - 1))
                return true;
        }
        return false;
    }

    public int isInterleave(String A, String B, String C) {
        if (A == null || B == null || C == null)
            return 0;
        if (A.length() + B.length() != C.length())
            return 0;
        boolean[][][] dp = new boolean[A.length() + 1][B.length() + 1][C.length() + 1];
        dp[0][0][0] = true;
        for (int i = 0; i <= A.length(); i++) {
            for (int j = 0; j <= B.length(); j++) {
                for (int k = 1; k <= C.length(); k++) {
                    if (i > 0 && A.charAt(i - 1) == C.charAt(k - 1)) {
                        if (dp[i - 1][j][k - 1])
                            dp[i][j][k] = true;
                    }
                    if (!dp[i][j][k] && j > 0 && B.charAt(j - 1) == C.charAt(k - 1)) {
                        if (dp[i][j - 1][k - 1])
                            dp[i][j][k] = true;
                    }
                }
            }
        }
        return dp[A.length()][B.length()][C.length()] ? 1 : 0;
    }

    public int isInterleave_optimized(String A, String B, String C) {
        if (A == null || B == null || C == null)
            return 0;
        if (A.length() + B.length() != C.length())
            return 0;
        boolean[][] dp = new boolean[A.length() + 1][B.length() + 1];
        for (int i = 1; i <= A.length(); i++) {
            if (A.charAt(i - 1) == C.charAt(i - 1))
                dp[i][0] = true;
            else
                break;
        }
        for (int i = 1; i <= B.length(); i++) {
            if (B.charAt(i - 1) == C.charAt(i - 1))
                dp[0][i] = true;
            else
                break;
        }
        for (int i = 0; i <= A.length(); i++) {
            for (int j = 0; j <= B.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else {
                    int k = i + j;
                    if (i > 0 && A.charAt(i - 1) == C.charAt(k - 1)) {
                        if (dp[i - 1][j])
                            dp[i][j] = true;
                    }
                    if (!dp[i][j] && j > 0 && B.charAt(j - 1) == C.charAt(k - 1)) {
                        if (dp[i][j - 1])
                            dp[i][j] = true;
                    }
                }
            }
        }
        return dp[A.length()][B.length()] ? 1 : 0;
    }

    public static void main(String[] args) {
        InterleavingString obj = new InterleavingString();
        System.out.println(obj.isInterleaveRec("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(obj.isInterleaveRec("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(obj.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(obj.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(obj.isInterleave("B", "e", "Be"));
        System.out.println(obj.isInterleaveRec("LgR8D8k7t8KIprKDTQ7aoo7ed6mhKQwWlFxXpyjPkh",
                "Q7wQk8rqjaH971SqSQJAMgqYyETo4KmlF4ybf",
                "Q7wLgR8D8Qkk7t88KIrpqjarHKD971SqSQJTQ7aoAMgoq7eYd6yETmhoK4KmlQwWFlF4xybXfpyjPkh"));
        System.out.println(obj.isInterleave("LgR8D8k7t8KIprKDTQ7aoo7ed6mhKQwWlFxXpyjPkh",
                "Q7wQk8rqjaH971SqSQJAMgqYyETo4KmlF4ybf",
                "Q7wLgR8D8Qkk7t88KIrpqjarHKD971SqSQJTQ7aoAMgoq7eYd6yETmhoK4KmlQwWFlF4xybXfpyjPkh"));
        System.out.println(obj.isInterleave_optimized("LgR8D8k7t8KIprKDTQ7aoo7ed6mhKQwWlFxXpyjPkh",
                "Q7wQk8rqjaH971SqSQJAMgqYyETo4KmlF4ybf",
                "Q7wLgR8D8Qkk7t88KIrpqjarHKD971SqSQJTQ7aoAMgoq7eYd6yETmhoK4KmlQwWFlF4xybXfpyjPkh"));
        System.out.println(obj.isInterleave_optimized("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(obj.isInterleave_optimized("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(obj.isInterleave_optimized("B", "e", "Be"));
    }
}
