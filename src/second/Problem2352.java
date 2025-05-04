package second;

/*
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

Example 1:


Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem2352 {

    public static void main(String[] args) {
        Solution2352 solution = new Solution2352();
        System.out.println(solution.equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
    }
}

class Solution2352 {
    public int equalPairs(int[][] grid) {
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int j = 0; j < grid.length; j++) {
                arr.add(grid[i][j]);
            }
            map.put(arr, map.getOrDefault(arr, 0) + 1);
        }

        for (int i = 0; i < grid.length; i++) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int j = 0; j < grid.length; j++) {
                arr.add(grid[j][i]);
            }

            if (map.containsKey(arr)) {
                res += map.get(arr);
            }
        }

        return res;
    }
}
