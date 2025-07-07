package second;
/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

  Example:

    Given the sorted array: [-10,-3,0,5,9],

    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

          0
         / \
       -3   9
       /   /
     -10  5
*/

public class Problem108_2 {
    public static void main(String[] args) {
        Solution108_2 solution = new Solution108_2();

        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode.inorder(solution.sortedArrayToBST(nums));
    }
}

class Solution108_2 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private TreeNode binarySearch(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int middle = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = binarySearch(nums, left, middle - 1);
        root.right = binarySearch(nums, middle + 1, right);

        return root;
    }
}
