package first;
/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

    Example:

    Input: head = 1->4->3->2->5->2, x = 3
    Output: 1->2->2->4->3->5
*/

public class Problem86 {
    public static void main(String[] args) {
        Solution86 solution = new Solution86();

        ListNode list = ListNode.createListNode(new int[]{1, 4, 3, 2, 5, 2});
        ListNode.displayListNode(solution.partition(list, 3));
    }
}

class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode beforeHead = before;
        ListNode afterHead = after;

        while (head != null) {
            if (head.val >= x) {
                afterHead.next = head;
                afterHead = afterHead.next;
            } else {
                beforeHead.next = head;
                beforeHead = beforeHead.next;
            }

            head = head.next;
        }

        afterHead.next = null;
        beforeHead.next = after.next;

        return before.next;
    }
}
