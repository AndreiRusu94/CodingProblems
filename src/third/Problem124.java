package third;
/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
*/

public class Problem124 {
    public static void main(String[] args) {
        Solution124 solution = new Solution124();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("Max path sum: " + solution.maxPathSum(root));
    }
}

class Solution124 {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxSum(root);
        return maxSum;
    }

    private int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeftSum = maxSum(root.left);
        int maxRightSum = maxSum(root.right);

        int maxRightLeft = Math.max(maxLeftSum, maxRightSum);
        int maxOneNodeSum = Math.max(root.val, (root.val + maxRightLeft));
        int maxAll = Math.max(maxOneNodeSum, maxLeftSum + maxRightSum + root.val);

        maxSum = Math.max(maxSum, maxAll);

        return maxOneNodeSum;
    }
}
