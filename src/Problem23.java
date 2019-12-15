/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */

public class Problem23 {
    public static void main(String[] args) {
        Solution23 solution = new Solution23();

        int[] input = {1, 2, 3};
        int[] secondInput = {2, 3, 4};
        ListNode[] lists = {ListNode.createListNode(input), ListNode.createListNode(secondInput)};
        ListNode.displayListNode(solution.mergeKLists(lists));
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode(int x) { val = x; }
 * }
 */
class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode h = head;

        int minIndex = 0;

        while (true) {
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        minIndex = i;
                    }

                    isBreak = false;
                }
            }

            if (isBreak) {
                break;
            }

            ListNode node = new ListNode(lists[minIndex].val);
            h.next = node;
            h = h.next;
            lists[minIndex] = lists[minIndex].next;
        }

        h.next = null;
        return head.next;
    }
}