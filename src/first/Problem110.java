package first;
/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

  Example 1:

    Given the following tree [3,9,20,null,null,15,7]:

        3
       / \
      9  20
        /  \
       15   7
    Return true.

  Example 2:

    Given the following tree [1,2,2,3,3,null,null,4,4]:

           1
          / \
         2   2
        / \
       3   3
      / \
     4   4
*/

public class Problem110 {
    public static void main(String[] args) {
        Solution110 solution = new Solution110();

        TreeNode tree = TreeNode.addRecursive(null, 1);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 3);
        tree = TreeNode.addRecursive(tree, 5);
        tree = TreeNode.addRecursive(tree, 6);

        System.out.println(solution.isBalanced(tree));
    }
}

class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftLength = treeLength(root.left);
        int rightLength = treeLength(root.right);

        return Math.abs(leftLength - rightLength) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int treeLength(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(treeLength(node.left), treeLength(node.right));
    }
}
