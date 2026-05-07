package fourth;
/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) in the tree.

A binary search tree satisfies the following constraints:

The left subtree of every node contains only nodes with keys less than the node's key.
The right subtree of every node contains only nodes with keys greater than the node's key.
Both the left and right subtrees are also binary search trees.
Example 1:

Input: root = [2,1,3], k = 1

Output: 1
*/

public class ProblemNC20 {
    public static void main(String[] args) {
        SolutionNC20 solution = new SolutionNC20();

        TreeNode tree = TreeNode.addRecursive(null, 5);
        tree = TreeNode.addRecursive(tree, 3);
        tree = TreeNode.addRecursive(tree, 9);
        tree = TreeNode.addRecursive(tree, 1);
        tree = TreeNode.addRecursive(tree, 4);

        System.out.println(solution.kthSmallest(tree, 3));
    }

}

class SolutionNC20 {
    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[2];
        tmp[0] = k;
        dfs(root, tmp);
        return tmp[1];
    }

    private void dfs(TreeNode node, int[] tmp) {
        if (node == null) {
            return;
        }

        dfs(node.left, tmp);
        if (tmp[0] == 0) {
            return;
        }

        tmp[0]--;
        if (tmp[0] == 0) {
            tmp[1] = node.val;
            return;
        }

        dfs(node.right, tmp);
    }
}