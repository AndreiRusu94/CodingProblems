package fourth;
/*
You are given an array of k linked lists, where each list is sorted in ascending order.

Return the sorted linked list that is the result of merging all of the individual linked lists.

Example 1:

Input: lists = [[1,2,4],[1,3,5],[3,6]]

Output: [1,1,2,3,3,4,5,6]
Example 2:

Input: lists = []

Output: []
Example 3:

Input: lists = [[]]

Output: []
*/

public class ProblemNC10 {
    public static void main(String[] args) {
        SolutionNC10 solution = new SolutionNC10();

        ListNode.displayListNode(solution.mergeKLists(new ListNode[]{
                ListNode.createListNode(new int[]{1, 2, 4}),
                ListNode.createListNode(new int[]{1, 3, 5}),
                ListNode.createListNode(new int[]{3, 6})
        }));
    }

}

class SolutionNC10 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeKListsHelper(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        }

        if (l == r) {
            return lists[l];
        }

        int mid = l + (r - l) / 2;
        ListNode left = mergeKListsHelper(lists, l, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, r);

        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.getVal() > l2.getVal()) {
                current.next = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                l1 = l1.next;
            }

            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }

        if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }
}