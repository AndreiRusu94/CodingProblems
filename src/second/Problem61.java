package second;
/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Return the linked list sorted as well.

  Example 1:

    Input: 1->2->3->3->4->4->5
    Output: 1->2->5
    Example 2:

    Input: 1->1->1->2->3
    Output: 2->3
 */

public class Problem61 {
    public static void main(String[] args) {
        Solution61 solution = new Solution61();

        ListNode list = ListNode.createListNode(new int[]{1, 2, 3, 4});
        ListNode.displayListNode(solution.rotateRight(list, 2));
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
