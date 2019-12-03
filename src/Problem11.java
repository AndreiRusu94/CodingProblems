/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines
are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 */

public class Problem11 {
    public static void main(String[] args) {
        Solution11 solution = new Solution11();

        int[] input = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(input));
    }
}

class Solution11 {
    public int maxArea(int[] height) {
        int maxArea = 0, leftIndex = 0, rightIndex = height.length - 1;

        while (leftIndex < rightIndex) {
            maxArea = Math.max(maxArea, (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]));

            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return maxArea;
    }
}