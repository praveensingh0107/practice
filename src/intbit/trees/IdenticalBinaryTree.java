package intbit.trees;

/**
 * Identical Binary Trees
 * Asked in:
 * Amazon
 * Given two binary trees, write a function to check if they are equal or not.
 * <p>
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * <p>
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * <p>
 * Example :
 * <p>
 * Input :
 * <p>
 * 1       1
 * / \     / \
 * 2   3   2   3
 * <p>
 * Output :
 * 1 or True
 */
public class IdenticalBinaryTree {
    public int isSameTree(TreeNode A, TreeNode B) {
        return isSameTreeUtil(A, B) ? 1 : 0;
    }

    private boolean isSameTreeUtil(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return true;
        if (A == null || B == null)
            return false;
        if (A.val == B.val)
            return isSameTreeUtil(A.left, B.left) && isSameTreeUtil(A.right, B.right);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        IdenticalBinaryTree obj = new IdenticalBinaryTree();
        System.out.println(obj.isSameTree(root, root));
    }
}
