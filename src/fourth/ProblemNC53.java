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
        System.out.println(solution.maxArea(new int[]{2, 4, 4, 5, 5, 8}));
    }
}

class SolutionNC53 {

    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(heights[l], heights[r]));
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }

}

