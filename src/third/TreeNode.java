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

    public static TreeNode insertNode(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);

        while (!dq.isEmpty()) {
            TreeNode curr = dq.poll();

            if (curr.left != null) {
                dq.add(curr.left);
            } else {
                curr.left = new TreeNode(data);
                return root;
            }

            if (curr.right != null) {
                dq.add(curr.right);
            } else {
                curr.right = new TreeNode(data);
                return root;
            }
        }

        return root;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            if (root.val == key) {
                return null;
            } else {
                return root;
            }
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        TreeNode curr = null;
        TreeNode keyNode = null;

        while (!dq.isEmpty()) {
            curr = dq.poll();

            if (curr.val == key) {
                keyNode = curr;
            }

            if (curr.left != null) {
                dq.add(curr.left);
            }

            if (curr.right != null) {
                dq.add(curr.right);
            }
        }

        if (keyNode != null) {
            keyNode.val = curr.val;
            deleteDeepest(root, curr);
        }

        return root;
    }

    private static void deleteDeepest(TreeNode root, TreeNode dNote) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);

        TreeNode curr = null;
        while (!dq.isEmpty()) {
            curr = dq.poll();

            if (curr == dNote) {
                curr = null;
                dNote = null;
                return;
            }

            if (curr.right != null) {
                if (curr.right == dNote) {
                    curr.right = null;
                    dNote = null;
                    return;
                }
                dq.add(curr.right);
            }

            if (curr.left != null) {
                if (curr.left == dNote) {
                    curr.left = null;
                    dNote = null;
                    return;
                }
                dq.add(curr.left);
            }
        }

    }

}
