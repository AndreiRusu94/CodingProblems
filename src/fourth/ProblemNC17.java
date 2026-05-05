package fourth;
/*
You are given the root node of a binary search tree (BST) and a value val to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Note: There may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

Example 1:

Input: root = [5,3,9,1,4], val = 6

Output: [5,3,9,1,4,6]
*/

public class ProblemNC17 {
    public static void main(String[] args) {
        SolutionNC17 solution = new SolutionNC17();

        TreeNode tree = TreeNode.addRecursive(null, 5);
        tree = TreeNode.addRecursive(tree, 3);
        tree = TreeNode.addRecursive(tree, 9);
        tree = TreeNode.addRecursive(tree, 1);
        tree = TreeNode.addRecursive(tree, 4);

        TreeNode.inorder(solution.insertIntoBST(tree, 6));
    }

}

class SolutionNC17 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}