package third;
/*
Given a Binary Tree, the task is to find its vertical traversal starting from the leftmost level to the rightmost level.
If multiple nodes pass through a vertical line, they should be printed as they appear in the level order traversal of the tree.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemDSA54 {
    public static void main(String[] args) {
        SolutionDSA54 solution = new SolutionDSA54();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        System.out.println(solution.verticalOrder(root));
    }
}

class SolutionDSA54 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        int[] mn = {0};
        Map<Integer, List<Integer>> hLevels = new HashMap<>();

        dfs(root, mn, 0, hLevels);

        List<List<Integer>> output = new ArrayList<>();
        int hd = mn[0];
        while (hLevels.containsKey(hd)) {
            output.add(hLevels.get(hd));
            hd++;
        }

        return output;
    }

    private void dfs(TreeNode node, int[] mn, int hd, Map<Integer, List<Integer>> hLevels) {
        if (node == null) {
            return;
        }

        if (!hLevels.containsKey(hd)) {
            hLevels.put(hd, new ArrayList<>());
        }

        hLevels.get(hd).add(node.val);

        mn[0] = Math.min(hd, mn[0]);

        dfs(node.left, mn, hd - 1, hLevels);
        dfs(node.right, mn, hd + 1, hLevels);
    }


}