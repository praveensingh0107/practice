package tree;

public class Successor {

    public static Tree inOrderSuccessor(Tree root) {
        if (root == null)
            return root;
        if (root.getRight() != null) {
            return leftMostChild(root.getRight());
        } else {
            while (root.getParent() != null && root.getParent().getLeft() != root) {
                root = root.getParent();
            }
            return root.getParent();
        }
    }

    private static Tree leftMostChild(Tree root) {
        if (root == null)
            return null;
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root;
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
        System.out.println(node1.getLeft().getRight());
        System.out.println(node1.getLeft().getRight().getParent());
        System.out.println(inOrderSuccessor(node1));
        System.out.println(inOrderSuccessor(node1.getRight().getLeft()));
    }

}
