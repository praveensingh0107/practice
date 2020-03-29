package intbit.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree, write a function to find the kth smallest element in the tree.
 *
 * Example :
 *
 * Input :
 *   2
 *  / \
 * 1   3
 *
 * and k = 2
 *
 * Return : 2
 *
 * As 2 is the second smallest element in the tree.
 *  NOTE : You may assume 1 <= k <= Total number of nodes in BST
 */
public class KthSmallestElement {
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

    public int kthsmallest(TreeNode A, int B) {
        List<Integer> b = new ArrayList<>();
        inOrderPopulateVal(A, b);
        return b.get(B-1);
    }

    private void inOrderPopulateVal(TreeNode a, List<Integer> b) {
        if (a != null) {
            inOrderPopulateVal(a.left, b);
            b.add(a.val);
            inOrderPopulateVal(a.right, b);
        }
    }

    public int kthsmallest_(TreeNode A, int B) {
        List<Integer> b = new ArrayList<>();
        b.add(B);
        return kthsmallestUtil(A, b);
    }

    private int kthsmallestUtil(TreeNode a, List<Integer> b) {
        if (a == null) return -1;
        int res = kthsmallestUtil(a.left, b);
        if (b.get(0) == 0) return res;
        res = a.val;
        b.set(0, b.get(0) -1);
        if (b.get(0) == 0) return res;
        return kthsmallestUtil(a.right, b);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        KthSmallestElement obj = new KthSmallestElement();
        System.out.println(obj.kthsmallest_(root, 2));
    }
}
