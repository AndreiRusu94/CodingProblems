package second;
/*
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
*/


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem637 {
    public static void main(String[] args) {
        Solution637 solution = new Solution637();

        TreeNode root = TreeNode.addRecursive(null, 1);
        root = TreeNode.addRecursive(root, 4);
        root = TreeNode.addRecursive(root, 2);
        root = TreeNode.addRecursive(root, 3);

        System.out.println(solution.averageOfLevels(root));
    }
}


class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> output = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            double average = 0;
            int counter = 0;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                average += current.val;
                counter++;

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            output.add(average / counter);
        }

        return output;
    }
}


