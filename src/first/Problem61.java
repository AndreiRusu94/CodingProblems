package first;
/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

  Example 1:

    Input: 1->2->3->4->5->NULL, k = 2
    Output: 4->5->1->2->3->NULL
    Explanation:
    rotate 1 steps to the right: 5->1->2->3->4->NULL
    rotate 2 steps to the right: 4->5->1->2->3->NULL

  Example 2:

    Input: 0->1->2->NULL, k = 4
    Output: 2->0->1->NULL
    Explanation:
    rotate 1 steps to the right: 2->0->1->NULL
    rotate 2 steps to the right: 1->2->0->NULL
    rotate 3 steps to the right: 0->1->2->NULL
    rotate 4 steps to the right: 2->0->1->NULL
 */

public class Problem61 {
    public static void main(String[] args) {
        Solution61 solution = new Solution61();

        int[] input = {1, 2, 3, 4, 5};
        ListNode.displayListNode(solution.rotateRight(ListNode.createListNode(input), 2));

    }
}

class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy, second = dummy;

        int listLength = 0;
        while (first.next != null) {
            first = first.next;
            listLength++;
        }

        for (int i = 0; i < listLength - k % listLength; i++) {
            second = second.next;
        }

        first.next = dummy.next;
        dummy.next = second.next;
        second.next = null;

        return dummy.next;
    }
}
