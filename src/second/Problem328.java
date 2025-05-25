package second;
/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Example 1:


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 */

public class Problem328 {
    public static void main(String[] args) {
        Solution328 solution = new Solution328();

        int[] input = {1, 2, 3, 4, 5, 6};
        ListNode.displayListNode(solution.oddEvenList(ListNode.createListNode(input)));
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode even = head.next;
            ListNode odd = head;
            ListNode evenHead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                even = even.next;
                odd = odd.next;
            }

            odd.next = evenHead;
        }

        return head;
    }
}