/*
Given a collection of intervals, merge all overlapping intervals.

  Example 1:

    Input: [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

  Example 2:

    Input: [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Problem56 {
    public static void main(String[] args) {
        Solution56 solution = new Solution56();

        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        System.out.println(Arrays.deepToString(solution.merge(nums)));
    }
}

class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}