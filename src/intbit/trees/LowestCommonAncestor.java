package intbit.trees;

import java.sql.ResultSet;

/**
 * Least Common Ancestor
 * Asked in:
 * Facebook
 * Adobe
 * Microsoft
 * Amazon
 * Google
 * Find the lowest common ancestor in an unordered binary tree given two values in the tree.
 *
 *  Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
 * Example :
 *
 *
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2_     0        8
 *          /   \
 *          7    4
 * For the above tree, the LCA of nodes 5 and 1 is 3.
 *
 *  LCA = Lowest common ancestor
 * Please note that LCA for nodes 5 and 4 is 5.
 *
 * You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
 * No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
 * There are no duplicate values.
 * You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
 */
public class LowestCommonAncestor {
    public int lca(TreeNode A, int B, int C) {
        if (A == null)
            return -1;
        boolean isBothPresent = isPresent(A, B) && isPresent(A, C);
        if (!isBothPresent)
            return -1;
        return lcaUtil(A, B, C);
    }

    private int lcaUtil(TreeNode root, int a, int b) {
        if (root == null)
            return -1;
        if (root.val == a|| root.val == b)
            return root.val;
        int left = lcaUtil(root.left, a, b);
        if (left != -1 && left != a && left != b)
            return left;
        int right = lcaUtil(root.right, a, b);
        if (right != -1 && right != a && right != b)
            return right;
        if (left != -1 && right != -1)
            return root.val;
        else if (left == -1 || right == -1)
            return left == -1? right : left;
        return -1;
    }

    private boolean isPresent(TreeNode root, int val) {
        if (root == null)
            return false;
        return (root.val == val) || isPresent(root.left, val) || isPresent(root.right, val);
    }

    static class Result{
        public int val = -1;
        public boolean isAncestor;
        public Result(){}
        public Result(int val, boolean isAncestor) {
            this.val = val;
            this.isAncestor = isAncestor;
        }
    }

    public int lca_(TreeNode A, int B, int C) {
        Result r = lcaHelper(A, B, C);
        if (r.isAncestor)
            return r.val;
        return -1;
    }

    private Result lcaHelper(TreeNode root, int b, int c) {
        if (root == null)
            return new Result();
        if (root.val == b && root.val == c)
            return new Result(root.val, true);
        Result left = lcaHelper(root.left, b, c);
        if (left.isAncestor)
            return left;
        Result right = lcaHelper(root.right, b, c);
        if (right.isAncestor)
            return right;
        if (left.val != -1 && right.val != -1)
            return new Result(root.val, true);
        else if (root.val == b || root.val == c) {
            boolean isAncestor = left.val != -1 || right.val != -1;
            return new Result(root.val, isAncestor);
        } else {
            return left.val != -1? left : right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        LowestCommonAncestor obj = new LowestCommonAncestor();
        /*System.out.println(obj.lca(root, 5, 1));
        System.out.println(obj.lca_(root, 5, 1));
        System.out.println(obj.lca(root, 5, 4));*/
        System.out.println(obj.lca_(root, 5, 4));
    }
}
