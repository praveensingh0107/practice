package tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

public class TreeTraversal {

    public static void inOrderWithStack(Tree root) {
        boolean done = false;
        Stack<Tree> stack = new Stack<>();
        while (!done) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                done = true;
            } else {
                root = stack.pop();
                System.out.print(root.data + " ");
                root = root.right;
            }
        }
        System.out.println();
    }

    public static void inorderWithStack_1(Tree root) {
        if (root == null) {
            return;
        }
        boolean isDone = false;
        Stack<Tree> stack = new Stack<>();
        while (!isDone) {
            if (root == null) {
                if (stack.isEmpty()) {
                    isDone = true;
                } else {
                    root = stack.pop();
                    System.out.print(root.getData() + " ");
                    root = root.getRight();
                }
            } else {
                stack.push(root);
                root = root.getLeft();
            }
        }
        System.out.println();
    }

    public static void inOrderMorrisTraversal(Tree root) {
        Tree current = root;
        Tree left = null;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                left = current.left;
                while (left.right != null && left.right != current) {
                    left = left.right;
                }
                if (left.right == null) {
                    left.right = current;
                    current = current.left;
                } else {
                    System.out.print(current.data + " ");
                    current = current.right;
                    left.right = null;
                }
            }
        }
        System.out.println();
    }

    public static void preOrderMorrisTraversal(Tree root) {
        Tree current = root;
        Tree left = null;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                left = current.left;
                while (left.right != null && left.right != current) {
                    left = left.right;
                }
                if (left.right == null) {
                    System.out.print(current.data + " ");
                    left.right = current;
                    current = current.left;
                } else {
                    left.right = null;
                    current = current.right;
                }
            }
        }
        System.out.println();
    }

    public static void diagonalTreversal(Tree root) {
        if (root == null)
            return;
        Map<Integer, LinkedList<Integer>> map = new TreeMap<Integer, LinkedList<Integer>>();
        diagonalTraversalUtil(root, map, 0);
        for (Entry<Integer, LinkedList<Integer>> e : map.entrySet()) {
            for (Integer val : e.getValue()) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void diagonalTraversalUtil(Tree root, Map<Integer, LinkedList<Integer>> map,
            int level) {
        if (root != null) {
            diagonalTraversalUtil(root.left, map, level + 1);
            LinkedList<Integer> list = map.get(level);
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(root.data);
            map.put(level, list);
            diagonalTraversalUtil(root.right, map, level);
        }
    }

    public static void main(String[] args) {
        Tree root1 = new Tree(1);
        Tree root2 = new Tree(2);
        Tree root3 = new Tree(3);
        Tree root4 = new Tree(4);
        Tree root5 = new Tree(5);
        Tree root6 = new Tree(6);
        Tree root7 = new Tree(7);
        root1.setLeft(root2);
        root1.setRight(root3);
        root2.setRight(root7);
        root3.setLeft(root4);
        root4.setLeft(root5);
        root4.setRight(root6);
        preOrderMorrisTraversal(root1);
        inOrderMorrisTraversal(root1);
        inOrderWithStack(root1);
        diagonalTreversal(root1);
        inorderWithStack_1(root1);
    }

}
