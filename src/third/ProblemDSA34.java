package third;

/*
Given a singly linked list, the task is to find the middle of the linked list. If the number of nodes are even, then there would be two middle nodes, so return the second middle node.

Example:

Input: linked list: 1->2->3->4->5
Output: 3
Explanation: There are 5 nodes in the linked list and there is one middle node whose value is 3.

Input: linked list = 10 -> 20 -> 30 -> 40 -> 50 -> 60
Output: 40
Explanation: There are 6 nodes in the linked list, so we have two middle nodes: 30 and 40, but we will return the second middle node which is 40.
*/

import static third.ListNode.createListNode;

public class ProblemDSA34 {

    public static void main(String[] args) {
        SolutionDSA34 solution = new SolutionDSA34();

        System.out.println(solution.getMiddle(createListNode(new int[]{10, 20, 30, 40, 50})));
    }
}

class SolutionDSA34 {

    public int getMiddle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.val;
    }

}