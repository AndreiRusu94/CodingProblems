package second;
/*
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem117 {
    public static void main(String[] args) {
        Solution117 solution = new Solution117();

        TreeNode tree = TreeNode.addRecursive(null, 6);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 0);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 8);
        tree = TreeNode.addRecursive(tree, 7);


        TreeNode.inorder(solution.connect(tree));
    }
}

class Solution117 {
    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return root;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        while (!dq.isEmpty()) {
            int size = dq.size();
            TreeNode prev = null;

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = dq.poll();

                if (prev != null) {
                    prev.next = currentNode;
                }

                prev = currentNode;

                if (currentNode.left != null) {
                    dq.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    dq.offer(currentNode.right);
                }
            }

        }

        return root;
    }
}
