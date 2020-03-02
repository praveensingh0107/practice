package intbit.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.
 * <p>
 * Return a deep copy of the list.
 * <p>
 * Example
 * <p>
 * Given list
 * <p>
 * 1 -> 2 -> 3
 * with random pointers going from
 * <p>
 * 1 -> 3
 * 2 -> 1
 * 3 -> 1
 * You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.
 */
public class CopyListProblem {
    static class RandomListNode {
        int label;

        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }

        @Override public String toString() {
            return "label: " + label;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode headOfCopyList = prepareList(head, map);
        assignRandomLink(head, headOfCopyList, map);
        return headOfCopyList;
    }

    private void assignRandomLink(RandomListNode head, RandomListNode headOfCopyList,
            Map<RandomListNode, RandomListNode> map) {
        RandomListNode current = head;
        RandomListNode currentOfCopyList = headOfCopyList;
        while(current != null) {
            currentOfCopyList.random = map.get(current.random);
            current = current.next;
            currentOfCopyList = currentOfCopyList.next;
        }
    }

    private RandomListNode prepareList(RandomListNode head,
            Map<RandomListNode, RandomListNode> map) {
        RandomListNode current = head;
        RandomListNode currentOfCopyList = null;
        RandomListNode headOfCopyList = null;
        while (current != null) {
            RandomListNode node = new RandomListNode(current.label);
            if (headOfCopyList == null) {
                headOfCopyList = node;
                currentOfCopyList = node;
            } else {
                currentOfCopyList.next = node;
                currentOfCopyList = node;
            }
            map.put(current, currentOfCopyList);
            current = current.next;
        }
        return headOfCopyList;
    }

    public void traverse(RandomListNode head) {
        if (head!=null) {
            System.out.println(head + ", next: " + head.next + ", random: " + head.random);
            traverse(head.next);
        }
    }

    public static void main(String[] args) {
        CopyListProblem obj = new CopyListProblem();
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        node1.next = node2; node1.random = node3;
        node2.next = node3; node2.random = node1;
        node3.next = null; node3.random = node1;
        //System.out.println(node1);
        obj.traverse(node1);
        RandomListNode randomListNode = obj.copyRandomList(node1);
        obj.traverse(randomListNode);
    }
}
