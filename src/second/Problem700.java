package second;
/*
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

Example 1:


Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
Example 2:


Input: root = [4,2,7,1,3], val = 5
Output: []
*/


import java.util.ArrayDeque;
import java.util.Deque;

public class Problem700 {
    public static void main(String[] args) {
        Solution700 solution = new Solution700();

        TreeNode root = TreeNode.addRecursive(null, 1);
        root = TreeNode.addRecursive(root, 4);
        root = TreeNode.addRecursive(root, 2);
        root = TreeNode.addRecursive(root, 3);

        System.out.println(solution.searchBST(root, 2));
    }
}


class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = dq.poll();

                if (current.val == val) {
                    return current;
                }

                if (current.left != null) {
                    dq.offer(current.left);
                }

                if (current.right != null) {
                    dq.offer(current.right);
                }
            }
        }

        return null;
    }
}


