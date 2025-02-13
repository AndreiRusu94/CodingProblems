package second;
/*
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.
*/

public class Problem129 {
    public static void main(String[] args) {
        Solution129 solution = new Solution129();

        TreeNode root = TreeNode.addRecursive(null, 1);
        root = TreeNode.addRecursive(root, 4);
        root = TreeNode.addRecursive(root, 2);
        root = TreeNode.addRecursive(root, 3);

        System.out.println(solution.sumNumbers(root));
    }
}


class Solution129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int current) {
        if (root == null) {
            return 0;
        }

        current = current * 10 + root.val;
        if (root.left == null && root.right == null) {
            return current;
        }

        return dfs(root.left, current) + dfs(root.right, current);
    }
}


