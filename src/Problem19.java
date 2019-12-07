/*
Given a linked list, remove the n-th node from the end of list and return its head.

  Example:
    Given linked list: 1->2->3->4->5, and n = 2.

    After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
 */

public class Problem19 {
    public static void main(String[] args) {
        Solution19 solution = new Solution19();

        int[] input = {-1, 0, 1, 2, -1, -4};
        int n = 2;

        ListNode.displayListNode(solution.removeNthFromEnd(ListNode.createListNode(input), n));
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode element = dummy;
        ListNode delayedElement = dummy;

        for (int i = 0; i <= n; i++) {
            element = element.next;
        }

        while (element != null) {
            element = element.next;
            delayedElement = delayedElement.next;
        }

        delayedElement.next = delayedElement.next.next;

        return dummy.next;
    }
}