package second;
/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its level order traversal as:
    [
      [3],
      [9,20],
      [15,7]
    ]
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem102_2 {
    public static void main(String[] args) {
        Solution102_2 solution = new Solution102_2();

        TreeNode tree = TreeNode.addRecursive(null, 1);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 3);
        tree = TreeNode.addRecursive(tree, 5);
        tree = TreeNode.addRecursive(tree, 6);

        System.out.println(solution.levelOrder(tree));
    }
}

class Solution102_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> output = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();

        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = dq.poll();
                level.add(current.val);
                if (current.left != null) {
                    dq.offer(current.left);
                }

                if (current.right != null) {
                    dq.offer(current.right);
                }
            }
            output.add(level);
        }

        return output;
    }
}
