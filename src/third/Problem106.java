package third;
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

import java.util.ArrayDeque;
import java.util.Deque;

import static third.TreeNode.inOrderDFS;

public class Problem106 {
    public static void main(String[] args) {
        Solution106 solution = new Solution106();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        inOrderDFS(solution.connect(root));
    }
}

class Solution106 {
    public TreeNode connect(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        while(!dq.isEmpty()) {
            TreeNode rightNode = null;
            int size = dq.size();
            for (int i = size; i > 0; i--) {
                TreeNode curr = dq.poll();
                curr.next = rightNode;
                rightNode = curr;
                if (curr.right != null) {
                    dq.offer(curr.right);
                    dq.offer(curr.left);
                }
            }
        }

        return root;
    }
}
