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

import java.util.Comparator;
import java.util.PriorityQueue;

public class ProblemNC9 {
    public static void main(String[] args) {
        SolutionNC9 solution = new SolutionNC9();

        ListNode.displayListNode(solution.mergeKLists(new ListNode[]{
                ListNode.createListNode(new int[]{1, 2, 4}),
                ListNode.createListNode(new int[]{1, 3, 5}),
                ListNode.createListNode(new int[]{3, 6})
        }));
    }

}

class SolutionNC9 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt((ListNode::getVal)));

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode output = new ListNode(0);
        ListNode current = output;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;

            node = node.next;
            if (node != null) {
                minHeap.offer(node);
            }
        }

        return output.next;
    }
}