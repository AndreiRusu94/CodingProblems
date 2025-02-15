package second;

/*
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from
position left to position right, and return the reversed list.

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 */

import java.util.ArrayDeque;
import java.util.Deque;

import static second.ListNode.createListNode;
import static second.ListNode.outputListNode;

public class Problem92 {
    public static void main(String[] args) {
        Solution92 sol = new Solution92();
        ListNode output = sol.reverseBetween(createListNode(new int[]{1, 2, 3, 4, 5}), 2, 4);

        outputListNode(output);
    }
}

class Solution92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = new ListNode(head.val), rightNode = new ListNode(0);
        ListNode dummy = leftNode;

        int count = 1;
        Deque<ListNode> dq = new ArrayDeque<>();
        while (count <= right) {
            if (count == right) {
                rightNode = head.next;
            }

            if (count >= left) {
                dq.push(head);
            } else {
                leftNode.next = head;
                leftNode = leftNode.next;
            }

            head = head.next;
            count++;
        }

        while (!dq.isEmpty()) {
            leftNode.next = dq.pop();
            leftNode = leftNode.next;
        }

        leftNode.next = rightNode;

        return dummy.next;
    }
}