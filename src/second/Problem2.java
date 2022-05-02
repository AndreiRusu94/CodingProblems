package second;

import static second.ListNode.outputListNode;
import static second.ListNode.createListNode;

public class Problem2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode output = solution.addTwoNumbers(createListNode(new int[]{1, 2 , 3}), createListNode(new int[]{2, 3, 9}));

        outputListNode(output);
    }
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }
}