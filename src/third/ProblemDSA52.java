package third;
/*
Given a binary tree, the task is to connect the nodes that are at the same level. Given an addition next pointer for the same.Initially,
all the next right pointers point to garbage values, set these pointers to the point next right for each node.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ProblemDSA52 {
    public static void main(String[] args) {
        SolutionDSA52 solution = new SolutionDSA52();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(90);


        solution.connect(root);
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            TreeNode node = dq.poll();
            System.out.print(node.val + " ");
            if (node.next == null) {
                System.out.print("# ");
            }

            if (node.left != null) {
                dq.add(node.left);
            }

            if (node.right != null) {
                dq.add(node.right);
            }
        }
    }
}

class SolutionDSA52 {
    public void connect(TreeNode node) {
        Deque<TreeNode> dq = new ArrayDeque<>();

        dq.add(node);
        while (!dq.isEmpty()) {
            int size = dq.size();
            TreeNode curr = dq.poll();
            curr.next = null;

            if (curr.right != null) {
                dq.add(curr.right);
            }

            if (curr.left != null) {
                dq.add(curr.left);
            }

            for (int i = 1; i < size; i++) {
                TreeNode prev = dq.poll();
                prev.next = curr;
                curr = prev;

                if (curr.right != null) {
                    dq.add(curr.right);
                }
                if (curr.left != null) {
                    dq.add(curr.left);
                }
            }

        }

    }


}