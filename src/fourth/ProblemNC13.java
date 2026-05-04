package fourth;
/*
You are given the root of a binary tree root. Invert the binary tree and return its root.

Example 1:

Input: root = [1,2,3,4,5,6,7]

Output: [1,3,2,7,6,5,4]
*/

import java.util.ArrayDeque;
import java.util.Deque;

import static fourth.TreeNode.inorder;

public class ProblemNC13 {
    public static void main(String[] args) {
        SolutionNC13 solution = new SolutionNC13();

        TreeNode tree = TreeNode.addRecursive(null, 6);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 0);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 8);
        tree = TreeNode.addRecursive(tree, 7);


        inorder(solution.invertTree(tree));

        System.out.println(solution.invertTree(tree));
    }

}

class SolutionNC13 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            TreeNode node = dq.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                dq.offer(node.left);
            }

            if (node.right != null) {
                dq.offer(node.right);
            }
        }

        return root;
    }
}