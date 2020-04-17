/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

    For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

        1
       / \
      2   2
     / \ / \
    3  4 4  3


    But the following [1,2,2,null,3,null,3] is not:

        1
       / \
      2   2
       \   \
       3    3
*/

public class Problem101 {
    public static void main(String[] args) {
        Solution101 solution = new Solution101();

        TreeNode tree = TreeNode.addRecursive(null, 1);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 3);

        System.out.println(solution.isSymmetric(tree));
    }
}

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode firstNode, TreeNode secondNode) {
        if (firstNode == null && secondNode == null) {
            return true;
        }

        if (firstNode == null || secondNode == null) {
            return false;
        }

        return firstNode.val == secondNode.val
                && isMirror(firstNode.left, secondNode.right)
                && isMirror(firstNode.right, secondNode.left);
    }
}
