package intbit.trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Preorder Traversal
 * Asked in:
 * Amazon
 * Microsoft
 * Given a binary tree, return the preorder traversal of its nodes’ values.
 * <p>
 * Example :
 * Given binary tree
 * <p>
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,2,3].
 */
public class PreOrderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        PreOrderTraversal obj = new PreOrderTraversal();
        System.out.println(obj.preorderTraversal(root));
    }
}
