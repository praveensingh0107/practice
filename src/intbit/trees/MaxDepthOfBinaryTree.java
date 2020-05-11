package intbit.trees;

/**
 * Max Depth of Binary Tree
 * Asked in:
 * Goldman Sachs
 * Facebook
 * Bloomberg
 * Microsoft
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * NOTE : The path has to end on a leaf node.
 * Example :
 * <p>
 * 1
 * /
 * 2
 * max depth = 2.
 */
public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode A) {
        if (A == null)
            return 0;
        return Math.max(maxDepth(A.left), maxDepth(A.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        //root.right.left = new TreeNode(3);
        MaxDepthOfBinaryTree obj = new MaxDepthOfBinaryTree();
        System.out.println(obj.maxDepth(root));
    }
}
