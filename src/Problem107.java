/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

  For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7],
      [9,20],
      [3]
    ]
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem107 {
    public static void main(String[] args) {
        Solution107 solution = new Solution107();

        TreeNode tree = TreeNode.addRecursive(null, 1);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 3);
        tree = TreeNode.addRecursive(tree, 5);
        tree = TreeNode.addRecursive(tree, 6);

        System.out.println(solution.levelOrderBottom(tree));
    }
}

class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> output = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> tempList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();

                tempList.add(node.val);

                if (node.left != null) {
                    nodes.add(node.left);
                }

                if (node.right != null) {
                    nodes.add(node.right);
                }
            }

            output.add(0, tempList);
        }

        return output;
    }
}
