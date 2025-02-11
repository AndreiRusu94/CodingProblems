package second;
/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

  For example, given

    preorder = [3,9,20,15,7]
    inorder = [9,3,15,20,7]
    Return the following binary tree:

        3
       / \
      9  20
        /  \
       15   7
*/

public class Problem105 {
    public static void main(String[] args) {
        Solution105 solution = new Solution105();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode.inorder(solution.buildTree(preorder, inorder));
    }
}

class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1, 0);
    }

    private TreeNode build(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }

        root.left = build(preorder, inorder, inStart, inIndex - 1, preStart + 1);
        root.right = build(preorder, inorder, inIndex + 1, inEnd, preStart + inIndex - inStart + 1);

        return root;
    }
}
