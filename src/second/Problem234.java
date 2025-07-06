package second;
/*
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
Example 1:

Input: head = [1,2,2,1]
Output: true
Example 2:

Input: head = [1,2]
Output: false

 */

public class Problem234 {
    public static void main(String[] args) {
        Solution234 solution = new Solution234();

        int[] input = {1, 2, 3, 4, 5, 6};
        System.out.println(solution.isPalindrome(ListNode.createListNode(input)));
    }
}

class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;

        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (fast != null) {
            next = next.next;
        }

        while (next != null) {
            if (prev.val != next.val) {
                return false;
            }

            prev = prev.next;
            next = next.next;
        }

        return true;
    }
}
