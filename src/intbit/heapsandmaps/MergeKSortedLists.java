package intbit.heapsandmaps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 *
 * Example :
 *
 * 1 -> 10 -> 20
 * 4 -> 11 -> 13
 * 3 -> 8 -> 9
 * will result in
 *
 * 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 */
public class MergeKSortedLists {

    static class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
    public ListNode mergeKLists(ArrayList<ListNode> a) {
      PriorityQueue<ListNode> queue =new PriorityQueue<ListNode>((o1, o2) -> o1.val - o2.val);
      ListNode head = null, last = null;
      for (ListNode node : a) {
        if (node != null) {
          queue.add(node);
        }
      }
      while(!queue.isEmpty()) {
        ListNode node = queue.poll();
        if (node.next != null) {
          queue.add(node.next);
        }
        if (head == null) {
          head = node;
          last = node;
        } else {
          last.next = node;
          last = node;
        }
      }
      return head;
    }

    public void printList(ListNode node) {
      ListNode current = node;
      while (current!=null) {
        System.out.print(current.val + ", ");
        current = current.next;
      }
      System.out.println();
    }

  /**
   * 1 -> 10 -> 20
   * 4 -> 11 -> 13
   * 3 -> 8 -> 9
   * @param args
   */
  public static void main(String[] args) {
        MergeKSortedLists obj = new MergeKSortedLists();
        ListNode l1 = new ListNode(1);
    ListNode l4 = new ListNode(4);
    ListNode l3 = new ListNode(3);
    ListNode l10 = new ListNode(10);
    ListNode l11 = new ListNode(11);
    ListNode l8 = new ListNode(8);
    ListNode l20 = new ListNode(20);
    ListNode l13 = new ListNode(13);
    ListNode l9 = new ListNode(9);
    l1.next = l10;l10.next = l20;
    l4.next = l11; l11.next = l13;
    l3.next = l8; l8.next = l9;
    obj.printList(l1);
    obj.printList(l4);
    obj.printList(l3);
    ArrayList<ListNode> list = new ArrayList<>();
    list.add(l1); list.add(l4); list.add(l3);
    ListNode listNode = obj.mergeKLists(list);
    obj.printList(listNode);
  }
}
