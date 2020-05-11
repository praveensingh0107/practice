package intbit.trees;

import java.util.ArrayList;
import java.util.Stack;

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

    public ArrayList<Integer> inorderTraversal_Stack(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        if (A == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        TreeNode current = null, prev = null;
        while (!stack.isEmpty()) {
            current = stack.peek();
            if (current.left == null && current.right == null) {
                prev = stack.pop();
                res.add(prev.val);
            } else {
                if (current.left != null && current.left != prev) {
                    stack.add(current.left);
                } else {
                    prev = stack.pop();
                    res.add(prev.val);
                    if (current.right != null) {
                        stack.push(current.right);
                    }
                }
            }
        }
        return res;
    }

    public ArrayList<Integer> inorderTraversal_Stack1(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        if (A == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        boolean isDone = false;
        TreeNode current = A;
        while (!isDone) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                if (stack.isEmpty()) {
                    isDone = true;
                } else {
                    current = stack.pop();
                    res.add(current.val);
                    current = current.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        InorderTraversal obj = new InorderTraversal();
        System.out.println(obj.inorderTraversal(root));
        System.out.println(obj.inorderTraversal_Stack(root));
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.right.left = new TreeNode(5);
        System.out.println(obj.inorderTraversal_Stack(root2));
        System.out.println(obj.inorderTraversal_Stack1(root2));
    }
}
