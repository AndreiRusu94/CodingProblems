package second;

/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
*/

import java.util.ArrayList;
import java.util.List;

public class Problem216 {

    public static void main(String[] args) {
        Solution216 solution = new Solution216();
        System.out.println(solution.combinationSum3(3, 9));

    }
}

class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        backtrack(k, n, output, current, 1);

        return output;
    }

    private void backtrack(int k, int target, List<List<Integer>> output, List<Integer> current, int start) {
        if (current.size() == k && target == 0) {
            List<Integer> li = new ArrayList<Integer>(current);
            output.add(li);
            return;
        }

        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(k, target - i, output, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}