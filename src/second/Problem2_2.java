package second;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

import static second.ListNode.createListNode;
import static second.ListNode.outputListNode;

public class Problem2_2 {
    public static void main(String[] args) {
        ListNode output = Solution2_2.addTwoNumbers(createListNode(new int[]{1, 2 , 3}), createListNode(new int[]{2, 3, 9}));

        outputListNode(output);
    }
}

class Solution2_2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = new ListNode(0);
        ListNode current = output;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            int sum = a + b + carry;
            carry = sum / 10;
            output.next = new ListNode(sum % 10);
            output = output.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            output.next = new ListNode(carry);
        }

        return current.next;
    }
}