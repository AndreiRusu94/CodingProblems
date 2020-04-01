/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 */


public class Problem42 {
    public static void main(String[] args) {
        Solution42 solution = new Solution42();

        int[] candidates = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(solution.trap(candidates));
    }
}

class Solution42 {
    public int trap(int[] height) {
        int output = 0;

        if (height == null || height.length == 0) {
            return output;
        }

        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;

        while (left <= right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    output += leftMax - height[left];
                }

                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    output += rightMax - height[right];
                }

                right--;
            }
        }

        return output;
    }
}