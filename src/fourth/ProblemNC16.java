package fourth;
/*
Given the root of a binary tree, return true if it is a valid binary search tree, otherwise return false.

A valid binary search tree satisfies the following constraints:

The left subtree of every node contains only nodes with keys less than the node's key.
The right subtree of every node contains only nodes with keys greater than the node's key.
Both the left and right subtrees are also binary search trees.
Example 1:

Input: root = [2,1,3]

Output: true
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ProblemNC16 {
    public static void main(String[] args) {
        SolutionNC16 solution = new SolutionNC16();

        TreeNode tree = TreeNode.addRecursive(null, 6);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 0);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 8);
        tree = TreeNode.addRecursive(tree, 7);

        System.out.println(solution.isValidBST(tree));
    }

}

class SolutionNC16 {
    private static class State {
        TreeNode node;
        long low;
        long high;

        public State(TreeNode node, long low, long high) {
            this.node = node;
            this.low = low;
            this.high = high;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<State> dq = new ArrayDeque<>();
        dq.offer(new State(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while (!dq.isEmpty()) {
            State current = dq.poll();
            TreeNode node = current.node;

            if (node.val <= current.low || node.val >= current.high) {
                return false;
            }

            if (node.left != null) {
                dq.offer(new State(node.left, current.low, node.val));
            }

            if (node.right != null) {
                dq.offer(new State(node.right, node.val, current.high));
            }
        }

        return true;
    }
}