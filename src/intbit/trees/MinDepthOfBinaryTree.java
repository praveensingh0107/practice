package intbit.trees;

/**
 * Min Depth of Binary Tree
 * Asked in:
 * Facebook
 * Amazon
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * NOTE : The path has to end on a leaf node.
 * Example :
 * <p>
 * 1
 * /
 * 2
 * min depth = 2.
 */
public class MinDepthOfBinaryTree {
    public int minDepth(TreeNode A) {
        if (A == null)
            return 0;
        return minDepthUtil(A);
    }

    private int minDepthUtil(TreeNode A) {
        if (A == null)
            return Integer.MAX_VALUE;
        if (A.left == null && A.right == null)
            return 1;
        return Math.min(minDepthUtil(A.left), minDepthUtil(A.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        MinDepthOfBinaryTree obj = new MinDepthOfBinaryTree();
        System.out.println(obj.minDepth(root));
    }
}
