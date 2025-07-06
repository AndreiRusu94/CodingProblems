package second;
/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:

Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 */

public class Problem206_2 {
    public static void main(String[] args) {
        Solution206_2 solution = new Solution206_2();

        int[] input = {1, 2, 3, 4, 5, 6};
        ListNode.displayListNode(solution.reverseList(ListNode.createListNode(input)));
    }
}

class Solution206_2 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
