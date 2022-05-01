package first;
/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

  Example:

    Given the sorted linked list: [-10,-3,0,5,9],

    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

          0
         / \
       -3   9
       /   /
     -10  5
*/

public class Problem109 {
    public static void main(String[] args) {
        Solution109 solution = new Solution109();

        int[] nums = {-10, -3, 0, 5, 9};

        ListNode head = ListNode.createListNode(nums);

        TreeNode.inorder(solution.sortedListToBST(head));
    }
}

class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode middle = findMiddleElement(head);

        TreeNode node = new TreeNode(middle.val);

        if (head == middle) {
            return node;
        }

        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(middle.next);

        return node;
    }

    private ListNode findMiddleElement(ListNode head) {
        ListNode previous = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (previous != null) {
            previous.next = null;
        }

        return slow;
    }
}
