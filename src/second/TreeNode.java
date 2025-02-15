package second;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    public TreeNode(int x) {
        this.val = x;
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

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        inorder(root.left);
        inorder(root.right);
    }
}