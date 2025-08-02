package third;
/*
Given an array and an integer k, the task is to find the sum of elements of a subarray containing at least k elements which has the largest sum.

Examples:

Input : arr[] = {-4, -2, 1, -3}, k = 2
Output : -1
Explanation : The sub array is {-2, 1}.

Input : arr[] = {1, 1, 1, 1, 1, 1} , k = 2
Output : 6
Explanation : The sub array is {1, 1, 1, 1, 1, 1}

*/

public class ProblemDSA11 {
    public static void main(String[] args) {
        SolutionDSA11 solution = new SolutionDSA11();
        System.out.println(solution.maxSumWithK(2, new int[]{-4, -2, 1, -3}));
    }
}

class SolutionDSA11 {

    public int maxSumWithK(int k, int[] arr) {
        int sum = 0, ans, last = 0, slow = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        ans = sum;

        for (int i = k; i < arr.length; i++) {
            sum += arr[i];
            last += arr[slow++];

            ans = Math.max(ans, sum);

            if (last < 0) {
                sum -= last;
                ans = Math.max(ans, sum);
                last = 0;
            }
        }

        return ans;
    }

}
