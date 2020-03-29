package intbit.trees;

import java.util.ArrayList;

public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        inorderTraversal(A, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, ArrayList<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        InorderTraversal obj = new InorderTraversal();
        System.out.println(obj.inorderTraversal(root));
    }
}
