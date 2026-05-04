package fourth;
/*
Given a binary tree root, return the level order traversal of it as a nested list, where each sublist contains the values of nodes at a particular level in the tree, from left to right.

Example 1:

Input: root = [1,2,3,4,5,6,7]

Output: [[1],[2,3],[4,5,6,7]]
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ProblemNC15 {
    public static void main(String[] args) {
        SolutionNC15 solution = new SolutionNC15();

        TreeNode tree = TreeNode.addRecursive(null, 6);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 0);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 8);
        tree = TreeNode.addRecursive(tree, 7);

        System.out.println(solution.levelOrder(tree));
    }

}

class SolutionNC15 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        List<List<Integer>> levels = new ArrayList<>();

        while (!dq.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = dq.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = dq.poll();
                level.add(node.val);

                if (node.left != null) {
                    dq.offer(node.left);
                }

                if (node.right != null) {
                    dq.offer(node.right);
                }
            }

            levels.add(level);
        }

        return levels;
    }
}