package third;
/*
Given a binary tree, the task is to find out if the tree can be folded or not. A tree can be folded if the left and right subtrees of the tree are
structure-wise mirror images of each other. An empty tree is considered foldable.

*/

public class Problem1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.println("Is foldable: " + solution.isFoldable(root));
    }
}

class Solution1 {
    public boolean isFoldable(TreeNode root) {
        if (root == null) {
            return true;
        }

        mirror(root.left);
        boolean ans = isSameStruct(root.left, root.right);
        mirror(root.left);

        return ans;
    }

    private void mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        mirror(root.left);
        mirror(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    private boolean isSameStruct(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return isSameStruct(left.left, right.left) && isSameStruct(left.right, right.right);
    }
}
