package third;

/*
Given a link list, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance
of numbers within each segregation should be the same as that in the original list.

NOTE: Don't create a new linked list, instead rearrange the provided one.
*/

import static third.ListNode.createListNode;
import static third.ListNode.displayListNode;

public class ProblemDSA36 {

    public static void main(String[] args) {
        SolutionDSA36 solution = new SolutionDSA36();

        var node = solution.segregateEvenOdd(createListNode(new int[]{10, 20, 30, 41, 55, 60}));
        displayListNode(node);
    }
}

class SolutionDSA36 {

    public ListNode segregateEvenOdd(ListNode head) {
        ListNode evenTail = null, evenHead = null;
        ListNode oddTail = null, oddHead = null;

        while (head != null) {
            if (head.val % 2 == 0) {
                if (evenHead == null) {
                    evenTail = evenHead = head;
                } else {
                    evenTail.next = head;
                    evenTail = evenTail.next;
                }
            } else {
                if (oddHead == null) {
                    oddHead = oddTail = head;
                } else {
                    oddTail.next = head;
                    oddTail = oddTail.next;
                }
            }
            head = head.next;
        }

        if (evenHead == null) {
            return oddHead;
        }

        evenTail.next = oddHead;

        if (oddTail != null) {
            oddTail.next = null;
        }

        return evenHead;
    }

}