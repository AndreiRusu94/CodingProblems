package second;

/*
Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.

For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Example 1:


Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem872 {

    public static void main(String[] args) {
        Solution872 solution = new Solution872();
        TreeNode tree = TreeNode.addRecursive(null, 1);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 200);

        TreeNode tree2 = TreeNode.addRecursive(null, 1);
        tree2 = TreeNode.addRecursive(tree2, 2);
        tree2 = TreeNode.addRecursive(tree2, 200);
        System.out.println(solution.leafSimilar(tree, tree2));
    }
}

class Solution872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        collectLeafs(q1, root1);
        collectLeafs(q2, root2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (!q1.poll().equals(q2.poll())) {
                return false;
            }
        }

        return q1.size() == q2.size();

    }

    private void collectLeafs(Queue<Integer> q, TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            q.offer(root.val);
        }

        collectLeafs(q, root.left);
        collectLeafs(q, root.right);
    }
}
