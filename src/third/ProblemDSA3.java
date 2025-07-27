package third;
/*
An interval is represented as a combination of start time and end time. Given a set of intervals, check if any two intervals intersect. 

Examples: 

Input:  arr[] = [[1, 3], [5, 7], [2, 4], [6, 8]]
Output: True
Explanation: The intervals {1, 3} and {2, 4} overlap

Input:  arr[] = [[1, 3], [7, 9], [4, 6], [10, 13]]
Output: False
Explanation: No pair of intervals overlap.

https://www.geeksforgeeks.org/dsa/check-if-any-two-intervals-overlap-among-a-given-set-of-intervals/

*/

public class ProblemDSA3 {
    public static void main(String[] args) {
        SolutionDSA3 solution = new SolutionDSA3();
        int[][] intervals = {{1, 3}, {7, 9}, {4, 6}, {10, 13}};
        System.out.println("Two intervals intersect: " + solution.isIntersect(intervals));
    }
}

class SolutionDSA3 {

    public boolean isIntersect(int[][] intervals) {
        int n = intervals.length;

        int maxEnd = 0;
        for (int i = 0; i < n; i++) {
            maxEnd = Math.max(maxEnd, intervals[i][1]);
        }

        int[] arr = new int[maxEnd + 2];

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            arr[start] += 1;
            arr[end + 1] -= 1;
        }

        for (int i = 1; i <= maxEnd; i++) {
            arr[i] += arr[i - 1];
            if (arr[i] > 1) {
                return true;
            }
        }

        return false;
    }

}
