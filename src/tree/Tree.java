package tree;

public class Tree {
    public int data;

    public Tree left;

    public Tree right;

    public Tree parent;

    public Tree() {
    }

    public Tree(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
        this.left.parent = this;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
        this.right.parent = this;
    }

    public Tree getParent() {
        return parent;
    }

    public void setParent(Tree parent) {
        this.parent = parent;
    }

    public void inOrderTraversal() {
        if (getLeft() != null) {
            getLeft().inOrderTraversal();
        }
        System.out.print(this.getData() + " ");
        if (getRight() != null) {
            getRight().inOrderTraversal();
        }
    }

    @Override public String toString() {
        return getData() + "";
    }
}
