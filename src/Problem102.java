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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem102 {
    public static void main(String[] args) {
        Solution102 solution = new Solution102();

        TreeNode tree = TreeNode.addRecursive(null, 1);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 3);
        tree = TreeNode.addRecursive(tree, 5);
        tree = TreeNode.addRecursive(tree, 6);

        System.out.println(solution.levelOrder(tree));
    }
}

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        List<List<Integer>> output = new ArrayList<>();

        nodes.add(root);
        int level, onLevel = 1;

        while (!nodes.isEmpty()) {
            level = onLevel;
            onLevel = 0;
            List<Integer> tempList = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                TreeNode current = nodes.remove();
                tempList.add(current.val);

                if (current.left != null) {
                    onLevel++;
                    nodes.add(current.left);
                }

                if (current.right != null) {
                    onLevel++;
                    nodes.add(current.right);
                }
            }

            output.add(new ArrayList<>(tempList));
        }

        return output;
    }
}
