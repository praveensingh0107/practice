package intbit.dp;

/**
 * Unique Binary Search Trees II
 * Asked in:
 * Amazon
 * Twitter
 * Samsung
 * Given an integer A, how many structurally unique BST’s (binary search trees) exist that can store values 1…A?
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument of input contains the integer, A.
 * Output Format:
 * <p>
 * Return an integer, representing the answer asked in problem statement.
 * Constraints:
 * <p>
 * 1 <= A <= 18
 * Example:
 * <p>
 * Input 1:
 * A = 3
 * <p>
 * Output 1:
 * 5
 * <p>
 * Explanation 1:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class UniqueBST2 {
    //A cannot be <1 as per Constrains
    public int numTrees(int A) {
        if (A == 1 || A == 2)
            return A;
        int[] dp = new int[A + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= A; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[A];
    }

    public static void main(String[] args) {
        UniqueBST2 obj = new UniqueBST2();
        System.out.println(obj.numTrees(3));
        System.out.println(obj.numTrees(4));
    }
}
