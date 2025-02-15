package second;
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return list1;
        }

        ListNode current = new ListNode(0);
        ListNode output = current;

        while (true) {
            if (list1 == null) {
                current.next = list2;
                return output.next;
            }

            if (list2 == null) {
                current.next = list1;
                return output.next;
            }

            ListNode ln = new ListNode(0);
            if (list1.val > list2.val) {
                ln = list2;
                list2 = list2.next;
            } else {
                ln = list1;
                list1 = list1.next;
            }

            current.next = ln;
            current = current.next;
        }
    }
}