package intbit.dp;

import java.util.Arrays;

/**
 * Palindrome Partitioning II
 * Asked in:
 * Amazon
 * Google
 * Given a string A, partition A such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of A.
 *
 *
 *
 * Input Format:
 *
 * The first and the only argument contains the string A.
 * Output Format:
 *
 * Return an integer, representing the answer as described in the problem statement.
 * Constraints:
 *
 * 1 <= length(A) <= 501
 * Examples:
 *
 * Input 1:
 *     A = "aba"
 *
 * Output 1:
 *     0
 *
 * Explanation 1:
 *     "aba" is already a palindrome, so no cuts are needed.
 *
 * Input 2:
 *     A = "aab"
 *
 * Output 2:
 *     1
 *
 * Explanation 2:
 *     Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartition {
    public int minCutRec(String A) {
        return minCutRec(A, 0, A.length()-1);
    }

    private int minCutRec(String str, int l, int r) {
        if (l > r || l == r)
            return 0;
        if (isPalindrome(str, l , r))
            return 0;
        int minCut = Integer.MAX_VALUE;
        for (int i = l +1; i <= r; i++) {
            minCut = Math.min(minCutRec(str, l, i - 1) + minCutRec(str, i , r) + 1, minCut);
        }
        return minCut;
    }

    private boolean isPalindrome(String str, int l, int r) {
        int size = (r -l + 1);
        for (int i = 0; i < size/2; i++) {
            if (str.charAt(l +i) != str.charAt(r -i))
                return false;
        }
        return true;
    }

    private int minCut(String str) {
        if (str == null || str.isEmpty())
            return 0;
        int size = str.length();
        int[][] dp = new int[size][size];
        boolean[][] isPalindrome = new boolean[size][size];
        for (int l = 2; l <= size; l++) {
            for (int i = 0; i + l <= size; i++) {
                int j = i + l - 1;
                isPalindrome[i][j] = str.charAt(i) == str.charAt(j) ?
                        ((i + 1 >= j - 1) ? true : isPalindrome[i + 1][j - 1]) :
                        false;
                if (isPalindrome[i][j]) {
                    dp[i][j] = 0;
                } else {
                    int minCut = Integer.MAX_VALUE;
                    for (int k = i + 1; k <= j; k++) {
                        minCut = Math.min(dp[i][k - 1] + dp[k][j] + 1, minCut);
                    }
                    dp[i][j] = minCut;
                }
            }
        }
        return dp[0][size - 1];
    }

    public static void main(String[] args) {
        PalindromePartition obj = new PalindromePartition();
        /*System.out.println(obj.minCutRec("aba"));
        System.out.println(obj.minCutRec("aab"));
        System.out.println(obj.minCutRec("ababb"));
        System.out.println(obj.minCutRec("aabca"));
        System.out.println(obj.minCutRec("abcd"));
        System.out.println(obj.minCutRec("abcda"));*/
        //System.out.println(obj.minCutRec("dVGAaVO25EmT6W3zSTEA0k12i64Kkmmli09Kb4fArlF4Gc2PknrlkevhROxUg"));
        System.out.println(obj.minCut("aba"));
        System.out.println(obj.minCut("aab"));
        System.out.println(obj.minCut("ababb"));
        System.out.println(obj.minCut("aabca"));
        System.out.println(obj.minCut("abcda"));
        System.out.println(obj.minCut("dVGAaVO25EmT6W3zSTEA0k12i64Kkmmli09Kb4fArlF4Gc2PknrlkevhROxUg"));
    }
}
