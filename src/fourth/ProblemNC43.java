package fourth;
/*
You are given an integer array arr, return the length of a maximum size turbulent subarray of arr.

A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:

For i <= k < j:
arr[k] > arr[k + 1] when k is odd, and
arr[k] < arr[k + 1] when k is even.
Or, for i <= k < j:
arr[k] > arr[k + 1] when k is even, and
arr[k] < arr[k + 1] when k is odd.
Example 1:

Input: arr = [2,4,3,2,2,5,1,4]

Output: 4
*/

public class ProblemNC43 {
    public static void main(String[] args) {
        SolutionNC43 solution = new SolutionNC43();
        System.out.println(solution.maxTurbulenceSize(new int[]{2, 4, 3, 2, 2, 5, 1, 4}));
    }
}

class SolutionNC43 {

    public int maxTurbulenceSize(int[] arr) {
        int l = 0, r = 1, output = 1;
        String prev = "";

        while (r < arr.length) {
            if (arr[r - 1] > arr[r] && !">".equals(prev)) {
                output = Math.max(output, r - l + 1);
                r++;
                prev = ">";
            } else if (arr[r - 1] < arr[r] && !"<".equals(prev)) {
                output = Math.max(output, r - l + 1);
                r++;
                prev = "<";
            } else {
                r = (arr[r] == arr[r - 1]) ? r + 1 : r;
                l = r - 1;
                prev = "";
            }
        }

        return output;
    }

}

