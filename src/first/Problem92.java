package first;
/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

    Example:

    Input: 1->2->3->4->5->NULL, m = 2, n = 4
    Output: 1->4->3->2->5->NULL
*/

public class Problem92 {
    public static void main(String[] args) {
        Solution92 solution = new Solution92();

        ListNode l1 = ListNode.createListNode(new int[]{2, 4, 4, 1, 5, 6, 4});

        ListNode.displayListNode(solution.reverseBetween(l1,2, 4));
    }
}

class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode current = head, previous = null;

        while (m > 1) {
            previous = current;
            current = current.next;
            m--;
            n--;
        }

        ListNode con = previous, tail = current;

        ListNode temp;

        while (n > 0) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
            n--;
        }

        if (con != null) {
            con.next = previous;
        } else {
            head = previous;
        }

        tail.next = current;

        return head;
    }
}
