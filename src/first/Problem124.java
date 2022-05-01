package first;
/*
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

  Example 1:

    Input: [1,2,3]

           1
          / \
         2   3

    Output: 6

  Example 2:

    Input: [-10,9,20,null,null,15,7]

       -10
       / \
      9  20
        /  \
       15   7

    Output: 42
*/

public class Problem124 {
    public static void main(String[] args) {
        Solution124 solution = new Solution124();

        TreeNode tree = TreeNode.addRecursive(null, 1);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 3);
        tree = TreeNode.addRecursive(tree, 5);
        tree = TreeNode.addRecursive(tree, 6);
        tree = TreeNode.addRecursive(tree, 1);

        System.out.println(solution.maxPathSum(tree));
    }
}

class Solution124 {
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxSum(root);
        return maxValue;
    }

    private int maxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, maxSum(node.left));
        int right = Math.max(0, maxSum(node.right));

        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
