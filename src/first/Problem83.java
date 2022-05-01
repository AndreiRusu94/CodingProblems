package first;
/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

    Example 1:

    Input: 1->1->2
    Output: 1->2
    Example 2:

    Input: 1->1->2->3->3
    Output: 1->2->3
*/

public class Problem83 {
    public static void main(String[] args) {
        Solution83 solution = new Solution83();

        ListNode list = ListNode.createListNode(new int[]{1, 1, 2, 3, 3, 4});
        ListNode.displayListNode(solution.deleteDuplicates(list));
    }
}

class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);

        dummy.next = head;

        while (head != null && head.next != null) {
            ListNode next = head.next;

            while (next != null && next.val == head.val) {
                head.next = next.next;
                next = next.next;
            }

            head = head.next;
        }

        return dummy.next;
    }
}
