package intbit.trees;

/**
 * Flatten Binary Tree to Linked List
 * Asked in:
 * Adobe
 * Amazon
 * Microsoft
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * Example :
 * Given
 *
 *
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * Note that the left child of all nodes should be NULL.
 */
public class FlattenBinaryTree {
    public TreeNode flatten(TreeNode a) {
        if (a == null)
            return null;
        TreeNode right = flatten(a.right);
        TreeNode left = flatten(a.left);
        a.left = a.right = null;
        left = addList(left, right);
        a = addList(a, left);
        return a;
    }

    private TreeNode addList(TreeNode left, TreeNode right) {
        if (left == null) return right;
        else if (right == null) return left;
        TreeNode current = left;
        while (current.right != null)
            current = current.right;
        current.right = right;
        return left;
    }

    public TreeNode flatten_(TreeNode a) {
        return flattenHelper(a, null);
    }

    private TreeNode flattenHelper(TreeNode a, TreeNode tail) {
        if (a == null)
            return tail;
        tail = flattenHelper(a.right, tail);
        a.right = flattenHelper(a.left, tail);
        a.left = null;
        return a;
    }

    public void printList(TreeNode root) {
        if (root != null) {
            if (root.left!=null)
            System.out.println("left: " + root.left);
            System.out.println("val: " + root.val);
            printList(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        FlattenBinaryTree obj = new FlattenBinaryTree();
        root = obj.flatten_(root);
        obj.printList(root);
    }
}
