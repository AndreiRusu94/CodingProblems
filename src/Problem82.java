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

public class Problem82 {
    public static void main(String[] args) {
        Solution82 solution = new Solution82();

        ListNode list = ListNode.createListNode(new int[]{1, 1, 2, 3, 3, 4});
        ListNode.displayListNode(solution.deleteDuplicates(list));
    }
}

class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode predecessor = dummy;
        ListNode current = head;

        while (current != null) {
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }

            if (predecessor.next == current) {
                predecessor = predecessor.next;
            } else {
                predecessor.next = current.next;
            }
            current = current.next;
        }

        return dummy.next;
    }
}
