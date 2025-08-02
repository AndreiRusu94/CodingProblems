package third;
/*
Trapping Rainwater Problem states that given an array of n non-negative integers arr[] representing an elevation map where the width of each bar
is 1, compute how much water it can trap after rain.

Examples:

Input: arr[] = [3, 0, 1, 0, 4, 0, 2]
Output: 10
Explanation: The expected rainwater to be trapped is shown in the above image.

Input: arr[] = [3, 0, 2, 0, 4]
Output: 7
Explanation: We trap 0 + 3 + 1 + 3 + 0 = 7 units.

Input: arr[] = [1, 2, 3, 4]
Output: 0
Explanation: We cannot trap water as there is no height bound on both sides

*/

public class ProblemDSA6 {
    public static void main(String[] args) {
        SolutionDSA6 solution = new SolutionDSA6();
        int[] arr = new int[]{3, 0, 2, 0, 4};
        System.out.println(solution.maxWater(arr));
    }
}

class SolutionDSA6 {

    public int maxWater(int[] arr) {
        int left = 1;
        int right = arr.length - 2;

        int leftMax = arr[left - 1];
        int rightMax = arr[right + 1];

        int res = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                res += Math.max(0, leftMax - arr[left]);

                leftMax = Math.max(leftMax, arr[left]);

                left++;
            } else {
                res += Math.max(0, rightMax - arr[right]);

                rightMax = Math.max(rightMax, arr[right]);

                right--;
            }
        }

        return res;
    }

}
