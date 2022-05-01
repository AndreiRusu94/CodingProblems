package first;
/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its zigzag level order traversal as:
    [
      [3],
      [20,9],
      [15,7]
    ]
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem103 {
    public static void main(String[] args) {
        Solution103 solution = new Solution103();

        TreeNode tree = TreeNode.addRecursive(null, 1);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 3);
        tree = TreeNode.addRecursive(tree, 5);
        tree = TreeNode.addRecursive(tree, 6);

        System.out.println(solution.zigzagLevelOrder(tree));
    }
}

class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        List<List<Integer>> output = new ArrayList<>();

        int size = 1;
        boolean order = true;
        nodes.add(root);

        while (!nodes.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();

                if (order) {
                    tempList.add(node.val);
                } else {
                    tempList.add(0, node.val);
                }

                if (node.left != null) {
                    nodes.add(node.left);
                }

                if (node.right != null) {
                    nodes.add(node.right);
                }
            }

            size = nodes.size();
            output.add(new ArrayList<>(tempList));
            order = !order;
        }

        return output;
    }
}
