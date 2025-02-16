package second;
/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem230 {
    public static void main(String[] args) {
        Solution230 solution = new Solution230();

        TreeNode tree = TreeNode.addRecursive(null, 1);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 3);
        tree = TreeNode.addRecursive(tree, 5);
        tree = TreeNode.addRecursive(tree, 6);

        System.out.println(solution.kthSmallest(tree, 2));
    }
}

class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> bst = new ArrayDeque<>();
        TreeNode current = root;
        int count = 0;

        while (!bst.isEmpty() || current != null) {
            while (current != null) {
                bst.push(current);
                current = current.left;
            }

            current = bst.pop();
            count++;

            if (count == k) {
                return current.val;
            }

            current = current.right;
        }

        return -1;
    }
}
