package fourth;
/*
You are given an array of non-negative integers height which represent an elevation map. Each value height[i] represents
the height of a bar, which has a width of 1.

Return the maximum area of water that can be trapped between the bars.

Example 1:

Input: height = [0,2,0,3,1,0,1,3,2,1]

Output: 9

*/

public class ProblemNC53 {
    public static void main(String[] args) {
        SolutionNC53 solution = new SolutionNC53();
        System.out.println(solution.trap(new int[]{0,2,0,3,1,0,1,3,2,1}));
    }
}

class SolutionNC53 {

    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int leftMax = height[0], rightMax = height[height.length - 1];
        int output = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                output += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                output += rightMax - height[r];
            }
        }

        return output;
    }

}

