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

    public static TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.val) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.val) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public static TreeNode insertLevelOrder(int[] nums, int i) {
        TreeNode root = null;

        if (i < nums.length) {
            root = new TreeNode(nums[i]);
            root.left = insertLevelOrder(nums, i * 2 + 1);
            root.right = insertLevelOrder(nums, i * 2 + 2);
        }

        return root;
    }

}
