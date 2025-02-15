package second;
/*
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

  Example 1:

    Input:     1         1
              / \       / \
             2   3     2   3

            [1,2,3],   [1,2,3]

    Output: true

  Example 2:

    Input:     1         1
              /           \
             2             2

            [1,2],     [1,null,2]

    Output: false

  Example 3:

    Input:     1         1
              / \       / \
             2   1     1   2

            [1,2,1],   [1,1,2]

    Output: false
*/

public class Problem100 {
    public static void main(String[] args) {
        Solution100 solution = new Solution100();

        TreeNode firstTree = TreeNode.addRecursive(null, 1);
        firstTree = TreeNode.addRecursive(firstTree, 4);
        firstTree = TreeNode.addRecursive(firstTree, 2);
        firstTree = TreeNode.addRecursive(firstTree, 3);

        TreeNode secondTree = TreeNode.addRecursive(null, 1);
        secondTree = TreeNode.addRecursive(secondTree, 4);
        secondTree = TreeNode.addRecursive(secondTree, 2);
        secondTree = TreeNode.addRecursive(secondTree, 3);

        System.out.println(solution.isSameTree(firstTree, secondTree));
    }
}

class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return (q == null);
        }

        if (q == null) {
            return false;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }
}
