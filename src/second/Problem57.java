package second;
/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

  Example 1:

    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]

  Example 2:

    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    Output: [[1,2],[3,10],[12,16]]
    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */

import java.util.Arrays;
import java.util.LinkedList;

public class Problem57 {
    public static void main(String[] args) {
        Solution57 solution = new Solution57();

        int[][] nums = {{1, 3}, {4, 6}, {8, 10}, {15, 18}};
        int[] newInterval = {3, 5};

        System.out.println(Arrays.deepToString(solution.insert(nums, newInterval)));
    }
}

class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> output = new LinkedList<>();
        boolean isNewIntervalInserted = false;

        for (int[] interval : intervals) {
            if (newInterval[0] > interval[1]) {
                output.add(interval);
            } else {
                if (newInterval[1] < interval[0]) {
                    if (!isNewIntervalInserted) {
                        output.add(newInterval);
                        isNewIntervalInserted = true;
                    }

                    output.add(interval);
                } else {
                    newInterval[0] = Math.min(newInterval[0], interval[0]);
                    newInterval[1] = Math.max(newInterval[1], interval[1]);
                }
            }
        }

        if (!isNewIntervalInserted) {
            output.add(newInterval);
        }

        return output.toArray(new int[output.size()][]);
    }
}