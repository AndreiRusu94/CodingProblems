package third;
/*
You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that i may equal j.

Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.

Example 1:

Input: intervals = [[1,2]]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:

Input: intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]
Explanation: There is no right interval for [3,4].
The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
Example 3:

Input: intervals = [[1,4],[2,3],[3,4]]
Output: [-1,2,-1]
Explanation: There is no right interval for [1,4] and [3,4].
The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.

*/

import java.util.Arrays;

public class Problem436 {
    public static void main(String[] args) {
        Solution436 solution = new Solution436();

        System.out.println(Arrays.toString(solution.findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}})));
    }
}

class Solution436 {

    public int[] findRightInterval(int[][] intervals) {
        int[][] starts = new int[intervals.length][2];

        for (int i = 0; i < intervals.length; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }

        Arrays.sort(starts, (a, b) -> a[0] - b[0]);
        int[] output = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            int idx = binarySearch(starts, end);

            output[i] = idx == -1 ? -1 : starts[idx][1];
        }

        return output;
    }

    private int binarySearch(int[][] starts, int target) {
        int left = 0, right = starts.length - 1;
        int idx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (starts[mid][0] >= target) {
                idx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return idx;
    }

}

