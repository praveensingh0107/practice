package intbit.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an inorder traversal of a cartesian tree, construct the tree.
 *
 *  Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree.
 *  Note: You may assume that duplicates do not exist in the tree.
 * Example :
 *
 * Input : [1 2 3]
 *
 * Return :
 *           3
 *          /
 *         2
 *        /
 *       1
 */
public class InorderCartesiantree {
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

    public TreeNode buildTree(ArrayList<Integer> A) {
        if (A == null || A.size() == 0)
            return null;
        return buildTree(A, 0, A.size()-1);
    }

    private TreeNode buildTree(ArrayList<Integer> a, int l, int r) {
        if (r < l)
            return null;
        else if (l == r)
            return new TreeNode(a.get(l));
        else {
            int index = getMaxValIndex(a, l, r);
            TreeNode root = new TreeNode(a.get(index));
            root.left = buildTree(a, l, index -1);
            root.right = buildTree(a, index + 1, r);
            return root;
        }
    }

    private int getMaxValIndex(ArrayList<Integer> a, int l, int r) {
        int maxIndex = l;
        for (int i = l + 1; i <= r; i++) {
            if (a.get(maxIndex) < a.get(i))
                maxIndex = i;
        }
        return maxIndex;
    }

    public void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print( root.val + " ");
            printInorder(root.right);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
        ArrayList<Integer> a = new ArrayList<>(list);
        InorderCartesiantree obj = new InorderCartesiantree();
        TreeNode root = obj.buildTree(a);
        obj.printInorder(root);
    }
}
