package third;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }

    static void preOrderDFS(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrderDFS(node.left);
            preOrderDFS(node.right);
        }
    }

    static void inOrderDFS(TreeNode node) {
        if (node != null) {
            inOrderDFS(node.left);
            System.out.print(node.val + " ");
            inOrderDFS(node.right);
        }
    }

    static void postOrderDFS(TreeNode node) {
        if (node != null) {
            postOrderDFS(node.left);
            postOrderDFS(node.right);
            System.out.print(node.val + " ");
        }
    }

    static void BFS(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);

        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = dq.poll();
                System.out.print(curr.val + " ");

                if (curr.left != null) {
                    dq.add(curr.left);
                }

                if (curr.right != null) {
                    dq.add(curr.right);
                }
            }
        }
    }

}
