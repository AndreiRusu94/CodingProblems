package fourth;
/*
You are given an integer array heights where heights[i] represents the height of the ith bar

You may choose any two bars to form a container. Return the maximum amount of water a container can store.

Example 1:

Input: height = [1,7,2,5,4,7,3,6]

Output: 36
Example 2:

Input: height = [2,2,2]

Output: 4
*/

public class ProblemNC52 {
    public static void main(String[] args) {
        SolutionNC52 solution = new SolutionNC52();
        System.out.println(solution.maxArea(new int[]{2, 4, 4, 5, 5, 8}));
    }
}

class SolutionNC52 {

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

