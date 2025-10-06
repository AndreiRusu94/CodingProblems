package third;
/*
Given an array of time intervals where arr[i] = [starti, endi], our task is to merge all the overlapping intervals into one and output the result
which should have only mutually exclusive intervals.

Examples:

Input: arr[] = [[1, 3], [2, 4], [6, 8], [9, 10]]
Output: [[1, 4], [6, 8], [9, 10]]
Explanation: In the given intervals, we have only two overlapping intervals [1, 3] and [2, 4]. Therefore, we will merge these two and return 
[[1, 4]], [6, 8], [9, 10]].

Input: arr[] = [[7, 8], [1, 5], [2, 4], [4, 6]]
Output: [[1, 6], [7, 8]]
Explanation: We will merge the overlapping intervals [[1, 5], [2, 4], [4, 6]] into a single interval [1, 6].
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ProblemDSA84 {
    public static void main(String[] args) {
        SolutionDSA84 solution = new SolutionDSA84();

        int[][] arr = {{7, 8}, {1, 5}, {2, 4}, {4, 6}};
        List<int[]> res = solution.mergeOverlap(arr);

        for (int[] interval : res)
            System.out.println(interval[0] + " " + interval[1]);
    }
}

class SolutionDSA84 {

    public List<int[]> mergeOverlap(int[][] arr) {
        List<int[]> output = new ArrayList<>();
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        output.add(new int[]{arr[0][0], arr[0][1]});

        for (int i = 1; i < arr.length; i++) {
            int[] last = output.get(output.size() - 1);
            int[] curr = arr[i];

            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                output.add(new int[]{curr[0], curr[1]});
            }
        }

        return output;
    }
}

