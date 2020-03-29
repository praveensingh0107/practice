package intbit.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree
 *
 *     struct TreeLinkNode {
 *       TreeLinkNode *left;
 *       TreeLinkNode *right;
 *       TreeLinkNode *next;
 *     }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *  Note:
 * You may only use constant extra space.
 * Example :
 *
 * Given the following binary tree,
 *
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * After calling your function, the tree should look like:
 *
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 *  Note 1: that using recursion has memory overhead and does not qualify for constant space.
 * Note 2: The tree need not be a perfect binary tree.
 */
public class PopulateNextRightPointer {
    public class TreeLinkNode {
        int val;

        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeLinkNode curr = q.poll();
            if (curr != null) {
                curr.next = q.peek();
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            } else {
                if (!q.isEmpty())
                    q.add(null);
            }
        }
    }

    public static void main(String[] args) {
        PopulateNextRightPointer obj = new PopulateNextRightPointer();
    }
}
