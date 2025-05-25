package second;
/*
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.

Example 1:

Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.

Example 2:

Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
Example 3:

Input: root = [1]
Output: 1
Explanation: Root is considered as good.
 */

public class Problem1448 {
    public static void main(String[] args) {
        Solution1448 solution = new Solution1448();

        TreeNode tree = TreeNode.addRecursive(null, 1);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 3);
        tree = TreeNode.addRecursive(tree, 5);
        tree = TreeNode.addRecursive(tree, 6);
        tree = TreeNode.addRecursive(tree, 1);
        
        System.out.println(solution.goodNodes(tree));
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
class Solution1448 {
    public int goodNodes(TreeNode root) {
        return goodNode(root, Integer.MIN_VALUE);
    }

    private int goodNode(TreeNode root, int currentMax) {
        if (root == null) {
            return 0;
        }

        int output = root.val >= currentMax ? 1 : 0;
        output += goodNode(root.left, Math.max(currentMax, root.val));
        output += goodNode(root.right, Math.max(currentMax, root.val));

        return output;
    }
}