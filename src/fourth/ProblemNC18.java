package fourth;
/*
You are given a root node reference of a BST and a key, delete the node with the given key in the BST, if present. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: There can be multiple results after deleting the node, return any one of them.

Example 1:

Input: root = [5,3,9,1,4], key = 3

Output: [5,4,9,1]
*/

public class ProblemNC18 {
    public static void main(String[] args) {
        SolutionNC18 solution = new SolutionNC18();

        TreeNode tree = TreeNode.addRecursive(null, 5);
        tree = TreeNode.addRecursive(tree, 3);
        tree = TreeNode.addRecursive(tree, 9);
        tree = TreeNode.addRecursive(tree, 1);
        tree = TreeNode.addRecursive(tree, 4);

        TreeNode.inorder(solution.deleteNode(tree, 3));
    }

}

class SolutionNC18 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            TreeNode current = root.right;
            while (current.left != null) {
                current = current.left;
            }
            root.val = current.val;
            root.right = deleteNode(root.right, current.val);
        }

        return root;
    }
}