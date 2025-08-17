package third;
/*
Given two Binary Search Trees (BST), the task is to print the in-order traversal of merged BSTs.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ProblemDSA53 {
    public static void main(String[] args) {
        SolutionDSA53 solution = new SolutionDSA53();

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(6);

        System.out.println(solution.merge(root1, root2));
    }
}

class SolutionDSA53 {
    public List<Integer> merge(TreeNode root1, TreeNode root2) {
        List<Integer> output = new ArrayList<>();
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();

        while (root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }

            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }

            if (stack2.isEmpty() || (!stack1.isEmpty() && stack1.peekFirst().val <= stack2.peekFirst().val)) {
                root1 = stack1.pop();
                output.add(root1.val);
                root1 = root1.right;
            } else {
                root2 = stack2.pop();
                output.add(root2.val);
                root2 = root2.right;
            }
        }

        return output;
    }


}