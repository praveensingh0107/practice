package intbit.trees;

/**
 * Given a binary tree, invert the binary tree and return it.
 * Look at the example for more details.
 *
 * Example :
 * Given binary tree
 *
 *      1
 *    /   \
 *   2     3
 *  / \   / \
 * 4   5 6   7
 * invert and return
 *
 *      1
 *    /   \
 *   3     2
 *  / \   / \
 * 7   6 5   4
 */
public class InvertTheBinaryTree {
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

    public TreeNode invertTree(TreeNode A) {
        if (A == null) return null;
        TreeNode temp = A.right;
        A.right = invertTree(A.left);
        A.left = invertTree(temp);
        return A;
    }

    public void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print( root.val + " ");
            printInorder(root.right);
        }
    }

    public static void main(String[] args) {
        InvertTheBinaryTree obj = new InvertTheBinaryTree();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        obj.printInorder(root);
        System.out.println();
        obj.invertTree(root);
        obj.printInorder(root);
    }
}
