package second;
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
        ListNode leftPartition = new ListNode(0), rightPartition = new ListNode(0), output, rpHead;
        output = leftPartition;
        rpHead = rightPartition;

        while (head != null) {
            if (head.val >= x) {
                rightPartition.next = head;
                rightPartition = rightPartition.next;
            } else {
                leftPartition.next = head;
                leftPartition = leftPartition.next;
            }

            head = head.next;
        }

        rightPartition.next = null;
        leftPartition.next = rpHead.next;

        return output.next;
    }
}
