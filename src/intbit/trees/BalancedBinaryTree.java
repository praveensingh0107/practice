package intbit.trees;

import tree.Tree;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 *  Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Example :
 *
 * Input :
 *           1
 *          / \
 *         2   3
 *
 * Return : True or 1
 *
 * Input 2 :
 *          3
 *         /
 *        2
 *       /
 *      1
 *
 * Return : False or 0
 *          Because for the root node, left subtree has depth 2 and right subtree has depth 0.
 *          Difference = 2 > 1.
 */
public class BalancedBinaryTree {

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



    public int isBalanced(TreeNode A) {
        return isBalanced(A, new Height()) ? 1: 0;
    }
    public boolean _isBalanced(TreeNode A) {
        if (A == null) return true;
        int diff = Math.abs(height(A.left) - height(A.right));
        if (diff >= 2)
            return false;
        else
            return _isBalanced(A.left) && _isBalanced(A.right);
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root, Height height) {
        if (root == null) {
            height.height = 0;
            return true;
        }
        Height lHeight = new Height(), rHeight = new Height();
        boolean l = isBalanced(root.left, lHeight);
        boolean r = isBalanced(root.right, rHeight);
        height.height = (Math.max(lHeight.height, rHeight.height) + 1);
        if (Math.abs(lHeight.height - rHeight.height) > 1)
            return false;
        return l && r;
    }

    static class Height {
        int height;
    }

    public int checkHeight(TreeNode root) {
        if (root == null)
            return -1;
        int lHeight = checkHeight(root.left);
        if (lHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int rHeight = checkHeight(root.right);
        if (rHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int heightDiff = Math.abs(lHeight - rHeight);
        if (heightDiff > 1)
            return Integer.MIN_VALUE;
        else
            return Math.max(lHeight, rHeight) + 1;
    }

    public int isBalancedCheck(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE ? 1 : 0;
    }

    public static void main(String[] args) {
        BalancedBinaryTree obj = new BalancedBinaryTree();
        System.out.println(obj.isBalanced(null));
        System.out.println(obj.isBalancedCheck(null));
    }
}
