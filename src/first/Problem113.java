package first;
/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

  Example:

    Given the below binary tree and sum = 22,

          5
         / \
        4   8
       /   / \
      11  13  4
     /  \    / \
    7    2  5   1
    Return:

    [
       [5,4,11,2],
       [5,8,4,5]
    ]
*/

import java.util.ArrayList;
import java.util.List;

public class Problem113 {
    public static void main(String[] args) {
        Solution113 solution = new Solution113();

        TreeNode tree = TreeNode.addRecursive(null, 1);
        tree = TreeNode.addRecursive(tree, 4);
        tree = TreeNode.addRecursive(tree, 2);
        tree = TreeNode.addRecursive(tree, 3);
        tree = TreeNode.addRecursive(tree, 5);
        tree = TreeNode.addRecursive(tree, 6);
        tree = TreeNode.addRecursive(tree, 1);

        System.out.println(solution.pathSum(tree, 10));
    }
}

class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> output = new ArrayList<>();
        generatePathSums(root, sum, 0, output, new ArrayList<>());

        return output;
    }

    private void generatePathSums(TreeNode node, int sum, int currentSum, List<List<Integer>> output, List<Integer> tempList) {
        if (node == null) {
            return;
        }

        tempList.add(node.val);
        currentSum += node.val;

        if (node.left == null && node.right == null) {
            if (currentSum == sum) {
                output.add(new ArrayList<>(tempList));
            }
        } else {
            if (node.left != null) {
                generatePathSums(node.left, sum, currentSum, output, tempList);
            }

            if (node.right != null) {
                generatePathSums(node.right, sum, currentSum, output, tempList);
            }
        }

        tempList.remove(tempList.size() - 1);
    }
}
