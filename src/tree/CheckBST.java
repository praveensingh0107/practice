package tree;

public class CheckBST {

    public static boolean isBST(Tree root) {
        Tree prevNode = null;
        return isBST(root, prevNode);
    }

    private static boolean isBST(Tree root, Tree prevNode) {
        if (root == null)
            return true;
        if (!isBST(root.getLeft(), prevNode))
            return false;
        if (prevNode != null && prevNode.getData() >= root.getData())
            return false;
        prevNode = root;
        if (!isBST(root.getRight(), prevNode))
            return false;
        return true;
    }

    public static void main(String[] args) {
        Tree node1 = new Tree(4);
        node1.setLeft(new Tree(2));
        node1.setRight(new Tree(6));
        node1.getLeft().setLeft(new Tree(1));
        node1.getLeft().setRight(new Tree(3));
        node1.getRight().setLeft(new Tree(5));
        node1.getRight().setRight(new Tree(7));
        node1.inOrderTraversal();
        System.out.println();
        System.out.println(isBST(node1));
    }

}
