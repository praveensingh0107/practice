package intbit.dp;

import intbit.trees.TreeNode;

/**
 * Max Sum Path in Binary Tree
 * Asked in:
 * Directi
 * Amazon
 * Given a binary tree T, find the maximum path sum.
 * <p>
 * The path may start and end at any node in the tree.
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument contains a pointer to the root of T, A.
 * Output Format:
 * <p>
 * Return an integer representing the maximum sum path.
 * Constraints:
 * <p>
 * 1 <= Number of Nodes <= 7e4
 * -1000 <= Value of Node in T <= 1000
 * Example :
 * <p>
 * Input 1:
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Output 1:
 * 6
 * <p>
 * Explanation 1:
 * The path with maximum sum is: 2 -> 1 -> 3
 * <p>
 * Input 2:
 * <p>
 * -10
 * /  \
 * -20  -30
 * <p>
 * Output 2:
 * -10
 * <p>
 * Explanation 2
 * The path with maximum sum is: -10
 */
public class MaxSumPathInBinaryTree {
    /*static class TreeNodeWithSum {
        public int sum = 0;
        public int val;
        public TreeNodeWithSum left;
        public TreeNodeWithSum right;
        public TreeNodeWithSum(int x) {
            this.val = x;
        }
    }*/

    public int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode A) {
        max = Integer.MIN_VALUE;
        maxPathSumHelper(A);
        return max;
    }

    private int maxPathSumHelper(TreeNode root) {
        if (root == null)
            return 0;
        int leftSum = Math.max(maxPathSumHelper(root.left), 0);
        int rightSum = Math.max(maxPathSumHelper(root.right), 0);
        max = Math.max(max, leftSum + root.val + rightSum);
        return root.val + Math.max(leftSum, rightSum);
    }

    /*private int getMaxPathSum(TreeNodeWithSum root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int leftMax = getMaxPathSum(root.left);
        int rightMax = getMaxPathSum(root.right);
        int sum = root.val;
        int leftSum = root.left == null? 0 : root.left.sum;
        int rightSum = root.right == null? 0: root.right.sum;
        sum = Math.max(sum, root.val + leftSum);
        sum = Math.max(sum, root.val + rightSum);
        root.sum = sum;
        int max = sum;
        return Math.max(max, Math.max(leftSum + root.val + rightSum, Math.max(leftMax, rightMax)));
    }

    private TreeNodeWithSum createTreeNodeWithSum(TreeNode a) {
        if (a == null)
            return null;
        TreeNodeWithSum root = new TreeNodeWithSum(a.val);
        root.left = createTreeNodeWithSum(a.left);
        root.right = createTreeNodeWithSum(a.right);
        return root;
    }*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(-1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);
        MaxSumPathInBinaryTree obj = new MaxSumPathInBinaryTree();
        System.out.println(obj.maxPathSum(root));
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println(obj.maxPathSum(root1));
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(-20);
        root2.right = new TreeNode(-30);
        System.out.println(obj.maxPathSum(root2));
    }
}
