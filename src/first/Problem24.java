package first;
/*
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.



Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

public class Problem24 {
    public static void main(String[] args) {
        Solution24 solution = new Solution24();

        int[] input = {1, 2, 3};
        ListNode.displayListNode(solution.swapPairs(ListNode.createListNode(input)));
    }
}

/**
 * Definition for singly-linked list.
 * public class first.ListNode {
 *      int val;
 *      first.ListNode next;
 *      first.ListNode(int x) { val = x; }
 * }
 */
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode firstNode = current.next;
            ListNode secondNode = current.next.next;
            firstNode.next = secondNode.next;
            current.next = secondNode;
            current.next.next = firstNode;
            current = current.next.next;
        }


        return dummy.next;
    }
}