package second;

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.
 */

public class Problem11_1 {

    public static void main(String[] args) {
        Solution11_1 solution = new Solution11_1();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height));
    }
}

class Solution11_1 {
    public int maxArea(int[] height) {
        int leftIndex = 0, rightIndex = height.length - 1, maxArea = 0;

        while (leftIndex < rightIndex) {
            maxArea = Math.max(maxArea, (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]));

            if (height[leftIndex] > height[rightIndex]) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        return maxArea;
    }
}
