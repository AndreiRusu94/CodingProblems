package third;

/*
Given a singly linked list, write a function to swap elements pairwise. For example, if the linked list is 1->2->3->4->5->6->7 then the function
should change it to 2->1->4->3->6->5->7, and if the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5

This problem has been discussed here. The solution provided there swaps data of nodes. If data contains many fields, there will be many swap
operations. So changing links is a better idea in general. Following is the implementation that changes links instead of swapping data.
*/

import static third.ListNode.createListNode;
import static third.ListNode.displayListNode;

public class ProblemDSA35 {

    public static void main(String[] args) {
        SolutionDSA35 solution = new SolutionDSA35();

        var node = solution.pairWiseSwap(createListNode(new int[]{10, 20, 30, 40, 50, 60}));
        displayListNode(node);
    }
}

class SolutionDSA35 {

    public ListNode pairWiseSwap(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        head = curr;

        while (true) {
            ListNode next = curr.next;
            curr.next = prev;

            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }

            prev.next = next.next;

            prev = next;
            curr = prev.next;
        }

        return head;

    }

}