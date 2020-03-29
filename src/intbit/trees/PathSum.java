package intbit.trees;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Example :
 *
 * Given the below binary tree and sum = 22,
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class PathSum {

    public int hasPathSum(TreeNode A, int B) {
        if (A == null)
            return B == 0? 1: 0;
        return hasPathSum(A, B, 0)? 1 : 0;
    }

    private boolean hasPathSum(TreeNode root, int B, int currentSum) {
        currentSum += root.val;
        if (root.left == null && root.right == null)
            return currentSum == B;
        boolean left = root.left == null ? false : hasPathSum(root.left, B, currentSum);
        if (left)
            return true;
        boolean right = root.right == null ? false : hasPathSum(root.right, B, currentSum);
        return right;
        /*if (root == null) {
            return currentSum == B;
        }
        currentSum += root.val;
        return hasPathSum(root.left, B, currentSum) || hasPathSum(root.right, B, currentSum);*/
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        PathSum obj = new PathSum();
        System.out.println(obj.hasPathSum(root, 27));
    }
}
