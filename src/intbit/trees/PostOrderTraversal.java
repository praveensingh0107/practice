package intbit.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Postorder Traversal
 * Asked in:
 * Amazon
 * Microsoft
 * Given a binary tree, return the postorder traversal of its nodes’ values.
 * <p>
 * Example :
 * <p>
 * Given binary tree
 * <p>
 * 1
 * \
 * 2
 * /
 * 3
 * return [3,2,1].
 * <p>
 * Using recursion is not allowed.
 */
public class PostOrderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        postorderTraversal(A, result);
        return result;
    }

    private void postorderTraversal(TreeNode root, ArrayList<Integer> result) {
        if (root != null) {
            postorderTraversal(root.left, result);
            postorderTraversal(root.right, result);
            result.add(root.val);
        }
    }

    public ArrayList<Integer> postorderTraversal_stack(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode current = A;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.add(current);
        while (!stack.isEmpty()) {
            current = stack.peek();
            if (current.left == null && current.right == null) {
                set.add(stack.pop());
                result.add(current.val);
            } else {
                if (current.left != null && !set.contains(current.left)) {
                    stack.push(current.left);
                } else if (current.right != null && !set.contains(current.right)) {
                    stack.push(current.right);
                } else {
                    set.add(stack.pop());
                    result.add(current.val);
                }
            }
        }
        return result;
    }

    /**
     * postOrder -> LRV
     * if reverse postOrder -> VRL
     * it looks like preOrder with right child first and then leftChild
     *
     * @param A
     * @return
     */
    public ArrayList<Integer> postorderTraversal_stack1(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        TreeNode current = A;
        while (!stack.isEmpty()) {
            current = stack.pop();
            result.add(current.val);
            if (current.left != null)
                stack.push(current.left);
            if (current.right != null)
                stack.push(current.right);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        PostOrderTraversal obj = new PostOrderTraversal();
        System.out.println(obj.postorderTraversal(root1));
        System.out.println(obj.postorderTraversal_stack(root1));
        System.out.println(obj.postorderTraversal_stack1(root1));
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.right.left = new TreeNode(5);
        System.out.println(obj.postorderTraversal(root2));
        System.out.println(obj.postorderTraversal_stack(root2));
        System.out.println(obj.postorderTraversal_stack1(root2));
    }
}
