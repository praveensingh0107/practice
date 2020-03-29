package intbit.trees;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * Example :
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * The above binary tree is symmetric.
 * But the following is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class SymmetricBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }
    public int isSymmetric(TreeNode A) {
        if (A == null)
            return 1;
        return isSymmetric(A.left, A.right)?1:0;
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if ((left == null && right != null) || (left != null && right == null))
            return false;
        return ((left.val == right.val) && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left));
    }

    public static void main(String[] args) {

    }
}
