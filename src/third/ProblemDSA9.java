package third;
/*
Given an integer array arr[] of size n, the task is to find the maximum of the minimums for every window size in the given array, where the window
size ranges from 1 to n.

Example:

Input: arr[] = [10, 20, 30]
Output: [30, 20, 10]
Explanation:
First element in output indicates maximum of minimums of all windows of size 1. Minimums of windows of size 1 are [10], [20], [30]. Maximum of
these minimums are 30 and similarly other outputs can be computed

Input: arr[] = [10, 20, 30, 50, 10, 70, 30]
Output: [70, 30, 20, 10, 10, 10, 10]
Explanation: The first element in the output indicates the maximum of minimums of all windows of size 1.
Minimums of windows of size 1 are [10], [20], [30], [50], [10], [70] and [30].
Maximum of these minimums is 70
The second element in the output indicates the maximum of minimums of all windows of size 2.
Minimums of windows of size 2 are [10], [20], [30], [10], [10], and [30].
Maximum of these minimums is 30
The third element in the output indicates the maximum of minimums of all windows of size 3.
Minimums of windows of size 3 are [10], [20], [10], [10] and [10].
Maximum of these minimums is 20
Similarly, other elements of output are computed.
*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ProblemDSA9 {
    public static void main(String[] args) {
        SolutionDSA9 solution = new SolutionDSA9();
        System.out.println(Arrays.toString(solution.maxOfMins(new int[]{10, 20, 30})));
    }
}

class SolutionDSA9 {

    public int[] maxOfMins(int[] arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = arr.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        int[] res = new int[n + 1];

        // find previous smaller element
        for (int i = 0; i < n; i++) {
            while(!dq.isEmpty() && arr[dq.peek()] >= arr[i]) {
                dq.pop();
            }

            prevSmaller[i] = dq.isEmpty() ? -1 : dq.peek();
            dq.push(i);
        }

        dq.clear();

        // find next smaller element
        for (int i = n - 1; i >= 0; i--) {
            if (!dq.isEmpty() && arr[dq.peek()] >= arr[i]) {
                dq.pop();
            }

            nextSmaller[i] = dq.isEmpty() ? n : dq.peek();
            dq.push(i);
        }

        // For each element, find the length of window where it is minimum
        for (int i = 0; i < n; i++) {
           int windowSize = nextSmaller[i] - prevSmaller[i] - 1;
           res[windowSize] = Math.max(res[windowSize], arr[i]);
        }

        for (int i = n - 1; i >= 1; i--) {
            res[i] = Math.max(res[i + 1], res[i]);
        }

        return Arrays.copyOfRange(res, 1, n + 1);
    }

}
