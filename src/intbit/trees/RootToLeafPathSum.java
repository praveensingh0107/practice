package intbit.trees;

import java.util.ArrayList;

/**
 * Root to Leaf Paths With Sum
 * Asked in:
 * Microsoft
 * Yahoo
 * Amazon
 * Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
 * <p>
 * For example:
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class RootToLeafPathSum {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null)
            return result;
        ArrayList<Integer> currPath = new ArrayList<>();
        pathSumUtil(A, B, result, currPath);
        return result;
    }

    private void pathSumUtil(TreeNode A, int sum, ArrayList<ArrayList<Integer>> result,
            ArrayList<Integer> currPath) {
        currPath.add(A.val);
        if (A.left == null && A.right == null) {
            if (sum - A.val == 0) {
                result.add(new ArrayList<>(currPath));
            }
        } else {
            if (A.left != null)
                pathSumUtil(A.left, sum - A.val, result, currPath);
            if (A.right != null)
                pathSumUtil(A.right, sum - A.val, result, currPath);
        }
        currPath.remove(currPath.size() - 1);
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
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        RootToLeafPathSum obj = new RootToLeafPathSum();
        System.out.println(obj.pathSum(root, 22));
    }

}
