/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


  Example 1:

        2
       / \
      1   3

    Input: [2,1,3]
    Output: true

  Example 2:

        5
       / \
      1   4
         / \
        3   6

    Input: [5,1,4,null,null,3,6]
    Output: false
    Explanation: The root node's value is 5 but its right child's value is 4.
*/

public class Problem98 {
    public static void main(String[] args) {
        Solution98 solution = new Solution98();

        TreeNode root = TreeNode.addRecursive(null, 1);
        root = TreeNode.addRecursive(root, 4);
        root = TreeNode.addRecursive(root, 2);
        root = TreeNode.addRecursive(root, 3);

        System.out.println(solution.isValidBST(root));
    }
}

class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;

        if (lower != null && val <= lower) {
            return false;
        }

        if (upper != null && val >= upper) {
            return false;
        }

        if (!isValid(node.left, lower, val)) {
            return false;
        }

        return isValid(node.right, val, upper);
    }
}
