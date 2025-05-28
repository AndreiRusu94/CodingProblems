package second;
/*
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

Example 1:


Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation:
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
Example 2:

Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2
*/


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem1161 {
    public static void main(String[] args) {
        Solution1161 solution = new Solution1161();

        TreeNode root = TreeNode.addRecursive(null, 1);
        root = TreeNode.addRecursive(root, 4);
        root = TreeNode.addRecursive(root, 2);
        root = TreeNode.addRecursive(root, 3);

        System.out.println(solution.maxLevelSum(root));
    }
}


class Solution1161 {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int minLevel = 1, maxSum = Integer.MIN_VALUE, level = 1;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        TreeNode current;

        while (!dq.isEmpty()) {
            int size = dq.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                current = dq.poll();
                levelSum += current.val;

                if (current.left != null) {
                    dq.offer(current.left);
                }

                if (current.right != null) {
                    dq.offer(current.right);
                }
            }

            if (maxSum < levelSum) {
                maxSum = levelSum;
                minLevel = level;
            }
            level++;
        }

        return minLevel;
    }
}


