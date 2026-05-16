package fourth;
/*
You are given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive
(i.e. nums[left] + nums[left + 1] + ... + nums[right]).
Example 1:

Input: ["NumArray","sumRange","sumRange","sumRange"]
[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]

Output: [null,1,-1,-3]
Explanation: NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

*/

public class ProblemNC54 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        SolutionNC54.NumArray obj = new SolutionNC54.NumArray(nums);
        System.out.println(obj.sumRange(2, 5));
    }
}

class SolutionNC54 {

    static class NumArray {

        int[] prefix;

        public NumArray(int[] nums) {
            prefix = new int[nums.length];
            int total = 0;
            for (int i = 0; i < nums.length; i++) {
                total += nums[i];
                prefix[i] = total;
            }
        }

        public int sumRange(int left, int right) {
            int prefixSumRight = prefix[right];
            int prefixSumLeft = left > 0 ? prefix[left - 1] : 0;

            return prefixSumRight - prefixSumLeft;
        }
    }

}

