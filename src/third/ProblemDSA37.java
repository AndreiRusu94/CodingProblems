package third;
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

public class ProblemDSA37 {
    public static void main(String[] args) {
        SolutionDSA37 solution = new SolutionDSA37();

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
class SolutionDSA37 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }

        int mid = start + (end - start) / 2;
        ListNode right = mergeKListsHelper(lists, mid + 1, end);
        ListNode left = mergeKListsHelper(lists, start, mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }

        if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }
}