/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

    Example:

    Input: 1->2->3->4->5->NULL, m = 2, n = 4
    Output: 1->4->3->2->5->NULL
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem94 {
    public static void main(String[] args) {
        Solution94 solution = new Solution94();

        TreeNode root = TreeNode.addRecursive(null, 1);
        root = TreeNode.addRecursive(root, 4);
        root = TreeNode.addRecursive(root, 2);
        root = TreeNode.addRecursive(root, 3);

        System.out.println(solution.inorderTraversal(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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
}

class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }

            current = stack.pop();
            output.add(current.val);

            current = current.right;
        }

        return output;
    }
}
