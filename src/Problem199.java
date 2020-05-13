/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

  Example:

    Input: [1,2,3,null,5,null,4]
    Output: [1, 3, 4]
    Explanation:

       1            <---
     /   \
    2     3         <---
     \     \
      5     4       <---
*/


import java.util.*;

public class Problem199 {
    public static void main(String[] args) {
        Solution199 solution = new Solution199();

        TreeNode root = TreeNode.addRecursive(null, 1);
        root = TreeNode.addRecursive(root, 4);
        root = TreeNode.addRecursive(root, 2);
        root = TreeNode.addRecursive(root, 3);

        System.out.println(solution.rightSideView(root));
    }
}


class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        if (root == null) {
            return output;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();

        dq.offer(root);
        TreeNode prev, current;
        int size = 0;

        while (!dq.isEmpty()) {
            size = dq.size();
            prev = null;

            for (int i = 0; i < size; i++) {
                current = dq.poll();
                if (current.left != null) {
                    dq.offer(current.left);
                }

                if (current.right != null) {
                    dq.offer(current.right);
                }

                prev = current;
            }

            output.add(prev.val);
        }

        return output;
    }
}


