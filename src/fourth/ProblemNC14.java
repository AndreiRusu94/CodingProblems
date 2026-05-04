package fourth;
/*
Given the root of a binary tree, return its depth.

The depth of a binary tree is defined as the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:

Input: root = [1,2,3,null,null,4]

Output: 3
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ProblemNC14 {
    public static void main(String[] args) {
        SolutionNC14 solution = new SolutionNC14();

        TreeNode tree = TreeNode.addRecursive(null, 6);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 0);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 8);
        tree = TreeNode.addRecursive(tree, 7);

        System.out.println(solution.maxDepth(tree));
    }

}

class SolutionNC14 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        int level = 0;

        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = dq.poll();
                if (node.left != null) {
                    dq.offer(node.left);
                }

                if (node.right != null) {
                    dq.offer(node.right);
                }
            }
            level++;
        }

        return level;
    }
}