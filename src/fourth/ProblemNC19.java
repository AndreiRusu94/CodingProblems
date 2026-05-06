package fourth;
/*
You are given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:

Input: root = [1,2,3,4,5,6,7]

Output: [4,2,5,1,6,3,7]
*/

import java.util.ArrayList;
import java.util.List;

public class ProblemNC19 {
    public static void main(String[] args) {
        SolutionNC19 solution = new SolutionNC19();

        TreeNode tree = TreeNode.addRecursive(null, 5);
        tree = TreeNode.addRecursive(tree, 3);
        tree = TreeNode.addRecursive(tree, 9);
        tree = TreeNode.addRecursive(tree, 1);
        tree = TreeNode.addRecursive(tree, 4);

        System.out.println(solution.inorderTraversal(tree));
    }

}

class SolutionNC19 {
    public List<Integer> inorderTraversal(TreeNode root) {
        return dfs(root, new ArrayList<>());
    }

    private List<Integer> dfs(TreeNode root, List<Integer> output) {
        if (root == null) {
            return output;
        }

        dfs(root.left, output);
        output.add(root.val);
        dfs(root.right, output);

        return output;
    }
}