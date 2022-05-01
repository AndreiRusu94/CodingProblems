package first;
/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

  Example:

    Input: n = 4, k = 2
    Output:
    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
 */

import java.util.ArrayList;
import java.util.List;

public class Problem77 {
    public static void main(String[] args) {
        Solution77 solution = new Solution77();

        System.out.println(solution.combine(4, 2));
    }
}

class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();

        backtrack(output, n, k, new ArrayList<>(), 1);

        return output;
    }

    private void backtrack(List<List<Integer>> output, int n, int k, List<Integer> tempList, int start) {
        if (k == 0) {
            output.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i <= n - k + 1; i++) {
                tempList.add(i);
                backtrack(output, n, k - 1, tempList, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
