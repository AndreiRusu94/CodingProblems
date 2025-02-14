package second;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

import static second.ListNode.createListNode;
import static second.ListNode.outputListNode;

public class Problem2_3 {
    public static void main(String[] args) {
        Solution2_3 sol = new Solution2_3();
        ListNode output = sol.addTwoNumbers(createListNode(new int[]{1, 2 , 3}), createListNode(new int[]{2, 3, 9}));

        outputListNode(output);
    }
}

class Solution2_3 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode head = sum;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int l1Val = 0, l2Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }


            int currentSum = l1Val + l2Val + carry;
            carry = currentSum / 10;

            sum.next = new ListNode(currentSum % 10);
            sum = sum.next;
        }

        if (carry > 0 ) {
            sum.next = new ListNode(carry);
        }

        return head.next;
    }
}