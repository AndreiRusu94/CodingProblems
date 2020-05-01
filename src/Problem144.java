/*
Given a binary tree, return the preorder traversal of its nodes' values.

    Example:

    Input: [1,null,2,3]
       1
        \
         2
        /
       3

    Output: [1,2,3]
*/

import java.util.ArrayList;
import java.util.List;

public class Problem144 {
    public static void main(String[] args) {
        Solution144 solution = new Solution144();

        TreeNode root = TreeNode.addRecursive(null, 1);
        root = TreeNode.addRecursive(root, 4);
        root = TreeNode.addRecursive(root, 2);
        root = TreeNode.addRecursive(root, 3);

        List<Integer> output = solution.preorderTraversal(root);
        output.forEach(System.out::println);
    }
}

class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        preorder(output, root);

        return output;
    }

    private void preorder(List<Integer> output, TreeNode node) {
        if (node == null) {
            return;
        }

        output.add(node.val);
        preorder(output, node.left);
        preorder(output, node.right);
    }
}
