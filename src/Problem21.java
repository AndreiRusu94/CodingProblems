/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

  Example:
    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
 */

public class Problem21 {
    public static void main(String[] args) {
        Solution21 solution = new Solution21();

        int[] input = {1, 2, 3};
        int[] secondInput = {2, 3, 4};
        ListNode.displayListNode(solution.mergeTwoLists(ListNode.createListNode(input), ListNode.createListNode(secondInput)));
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return l1;
        }

        ListNode current = new ListNode(0);
        ListNode output = current;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                if (l2 != null) {
                    current.next = l2;
                    return output.next;
                } else {
                    return output.next;
                }
            }

            if (l2 == null) {
                if (l1 != null) {
                    current.next = l1;
                    return output.next;
                } else {
                    return output.next;
                }
            }

            ListNode ln;

            if (l1.val > l2.val) {
                ln = l2;
                l2 = l2.next;
            } else {
                ln = l1;
                l1 = l1.next;
            }

            current.next = ln;
            current = current.next;
        }

        return output;
    }
}