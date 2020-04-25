package intbit.dp;

/**
 * Distinct Subsequences
 * Asked in:
 * Google
 * Given two sequences A, B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.
 * <p>
 * Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, “ACE” is a subsequence of “ABCDE” while “AEC” is not).
 * <p>
 * Input Format:
 * <p>
 * The first argument of input contains a string, A.
 * The second argument of input contains a string, B.
 * Output Format:
 * <p>
 * Return an integer representing the answer as described in the problem statement.
 * Constraints:
 * <p>
 * 1 <= length(A), length(B) <= 700
 * Example :
 * <p>
 * Input 1:
 * A = "abc"
 * B = "abc"
 * <p>
 * Output 1:
 * 1
 * <p>
 * Explanation 1:
 * Both the strings are equal.
 * <p>
 * Input 2:
 * A = "rabbbit"
 * B = "rabbit"
 * <p>
 * Output 2:
 * 3
 * <p>
 * Explanation 2:
 * These are the possible removals of characters:
 * => A = "ra_bbit"
 * => A = "rab_bit"
 * => A = "rabb_it"
 * <p>
 * Note: "_" marks the removed character.
 */
public class DistinctSubsequence {
    public int numDistinct(String A, String B) {
        if (A == null && B == null)
            return 1;
        if (A == null || A.length() < B.length())
            return 0;
        if (B == null || B.length() == 0)
            return 1;
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int r = 0; r <= A.length(); r++) {
            dp[r][0] = 1;
        }
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[A.length()][B.length()];
    }

    public int numDistinctRec(String A, String B) {
        if (A == null && B == null)
            return 1;
        if (A == null || A.length() < B.length())
            return 0;
        if (B == null || B.length() == 0)
            return 1;
        return numDistinctRec(A, A.length() - 1, B, B.length() - 1);
    }

    private int numDistinctRec(String a, int l, String b, int r) {
        if (r < 0)
            return 1;
        if (l < r)
            return 0;
        boolean isSame = a.charAt(l) == b.charAt(r);
        if (isSame) {
            return numDistinctRec(a, l - 1, b, r - 1) + numDistinctRec(a, l - 1, b, r);
        } else {
            return numDistinctRec(a, l - 1, b, r);
        }
    }

    public static void main(String[] args) {
        DistinctSubsequence obj = new DistinctSubsequence();
        System.out.println(obj.numDistinctRec("rabbbit", "rabbit"));
        System.out.println(obj.numDistinctRec("abc", "abc"));
        System.out.println(obj.numDistinctRec("aaaababbababbaabbaaababaaabbbaaabbb", "bbababa"));
        System.out.println(obj.numDistinct("rabbbit", "rabbit"));
        System.out.println(obj.numDistinct("abc", "abc"));
        System.out.println(obj.numDistinct("aaaababbababbaabbaaababaaabbbaaabbb", "bbababa"));
    }
}
