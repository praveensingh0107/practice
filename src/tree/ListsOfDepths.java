package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListsOfDepths {

    public static List<LinkedList<Tree>> createListOfDepths(Tree root) {
        if (root == null)
            return null;
        List<LinkedList<Tree>> result = new ArrayList<>();
        LinkedList<Tree> levelList = new LinkedList<>();
        Tree dummyTree = new Tree();
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        q.add(dummyTree);
        while (!q.isEmpty()) {
            Tree node = q.poll();
            if (node == dummyTree) {
                result.add(levelList);
                if (!q.isEmpty()) {
                    levelList = new LinkedList<>();
                    q.add(dummyTree);
                }
            } else {
                levelList.add(node);
                if (node.getLeft() != null) {
                    q.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    q.add(node.getRight());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Tree node1 = new Tree(4);
        node1.setLeft(new Tree(2));
        node1.setRight(new Tree(6));
        node1.getLeft().setLeft(new Tree(1));
        node1.getLeft().setRight(new Tree(3));
        node1.getRight().setLeft(new Tree(5));
        node1.getRight().setRight(new Tree(7));
        //node1.inOrderTraversal();
        List<LinkedList<Tree>> result = createListOfDepths(node1);
        System.out.println(result);
    }

}
