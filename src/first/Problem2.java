package first;
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order
and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

  Example:
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
*/

public class Problem2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        ListNode l1 = ListNode.createListNode(new int[]{2, 4, 3});
        ListNode l2 = ListNode.createListNode(new int[]{5, 6, 4});

        ListNode.displayListNode(solution.addTwoNumbers(l1, l2));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode createListNode(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode node = new ListNode(values[0]);
        ListNode head = node;

        for (int value : values) {
            node.next = new ListNode(value);
            node = node.next;
        }

        return head.next;
    }

    public static void displayListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

        System.out.println();
    }
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode x = l1, y = l2, current = dummy;

        int carry = 0;

        while (x != null || y != null) {
            int val1 = (x != null) ? x.val : 0;
            int val2 = (y != null) ? y.val : 0;

            int sum = val1 + val2 + carry;

            carry = sum / 10;

            current.next = new ListNode(sum % 10);

            current = current.next;

            if (x != null) x = x.next;
            if (y != null) y = y.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }
}