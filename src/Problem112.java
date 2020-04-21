/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

  Example:

    Given the below binary tree and sum = 22,

          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/

public class Problem112 {
    public static void main(String[] args) {
        Solution112 solution = new Solution112();

        TreeNode tree = TreeNode.addRecursive(null, 1);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 3);
        tree = TreeNode.addRecursive(tree, 5);
        tree = TreeNode.addRecursive(tree, 6);
        tree = TreeNode.addRecursive(tree, 1);

        System.out.println(solution.hasPathSum(tree, 10));
    }
}

class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasSum(root, sum, 0);
    }

    private boolean hasSum(TreeNode node, int sum, int currentSum) {
        if (node == null) {
            return false;
        }

        currentSum += node.val;
        boolean hasPathSum = false;

        if (node.left == null && node.right == null) {
            return currentSum == sum;
        } else {
            if (node.left != null) {
                hasPathSum = hasSum(node.left, sum, currentSum);
            }

            if (node.right != null) {
                hasPathSum = hasPathSum || hasSum(node.right, sum, currentSum);
            }
        }

        return hasPathSum;
    }
}
