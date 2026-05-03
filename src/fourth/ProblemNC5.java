package fourth;
/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

  Example:
    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
 */

public class ProblemNC5 {
    public static void main(String[] args) {
        SolutionNC5 solution = new SolutionNC5();

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
class SolutionNC5 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode(0);
        ListNode mergedHead = mergedList;

        while (list1 != null && list2 != null) {
            if (list1.getVal() > list2.getVal()) {
                mergedList.next = list2;
                list2 = list2.next;
            } else {
                mergedList.next = list1;
                list1 = list1.next;
            }

            mergedList = mergedList.next;
        }

        if (list1 != null) {
            mergedList.next = list1;
        }

        if (list2 != null) {
            mergedList.next = list2;
        }

        return mergedHead.next;
    }
}