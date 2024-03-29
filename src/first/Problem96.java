package first;
/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

    Example:

    Input: 3
    Output: 5
    Explanation:
    Given n = 3, there are a total of 5 unique BST's:

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
*/

public class Problem96 {
    public static void main(String[] args) {
        Solution96 solution = new Solution96();

        System.out.println(solution.numTrees(3));
    }
}

class Solution96 {
    public int numTrees(int n) {
        int[] G = new int[n + 1];

        G[1] = G[0] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }
}
