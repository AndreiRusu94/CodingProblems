/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

  Example:

    Given binary tree [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7

    return its minimum depth = 2.
*/

import java.util.LinkedList;
import java.util.Queue;

public class Problem111 {
    public static void main(String[] args) {
        Solution111 solution = new Solution111();

        TreeNode tree = TreeNode.addRecursive(null, 1);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 3);
        tree = TreeNode.addRecursive(tree, 5);
        tree = TreeNode.addRecursive(tree, 6);
        tree = TreeNode.addRecursive(tree, 1);

        System.out.println(solution.minDepth(tree));
    }
}

class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int maxLength = 0;

        while (!nodes.isEmpty()) {
            maxLength++;
            int size = nodes.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();

                if (node.left == null) {
                    if (node.right == null) {
                        return maxLength;
                    } else {
                        nodes.add(node.right);
                    }
                } else {
                    nodes.add(node.left);

                    if (node.right != null) {
                        nodes.add(node.right);
                    }
                }
            }
        }

        return maxLength;
    }
}
