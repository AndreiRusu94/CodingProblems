package second;
/*
You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follows:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
Change the direction from right to left or from left to right.
Repeat the second and third steps until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.

Example 1:

Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
Example 2:


Input: root = [1,1,1,null,1,null,null,1,1,null,1]
Output: 4
Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
 */

public class Problem1372 {
    public static void main(String[] args) {
        Solution1372 solution = new Solution1372();

        TreeNode tree = TreeNode.addRecursive(null, 1);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 3);
        tree = TreeNode.addRecursive(tree, 5);
        tree = TreeNode.addRecursive(tree, 6);
        tree = TreeNode.addRecursive(tree, 1);

        System.out.println(solution.longestZigZag(tree));
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
class Solution1372 {
    private int maxStep = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, false, 0);
        dfs(root, true, 0);
        return maxStep;
    }

    private void dfs(TreeNode root, boolean isLeft, int step) {
        if (root == null) {
            return;
        }

        maxStep = Math.max(step, maxStep);
        if (isLeft) {
            dfs(root.left, false, step + 1);
            dfs(root.right, true, 1);
        } else {
            dfs(root.left, false, 1);
            dfs(root.right, true, step + 1);
        }
    }
}