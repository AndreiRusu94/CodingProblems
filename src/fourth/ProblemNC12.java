package fourth;
/*
You are given an integer array piles where piles[i] is the number of bananas in the ith pile. You are also given an integer h,
which represents the number of hours you have to eat all the bananas.

You may decide your bananas-per-hour eating rate of k. Each hour, you may choose a pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, you may finish eating the pile but you can not eat from another pile in the same hour.

Return the minimum integer k such that you can eat all the bananas within h hours.

Example 1:

Input: piles = [1,4,3,2], h = 9

Output: 2
Explanation: With an eating rate of 2, you can eat the bananas in 6 hours. With an eating rate of 1, you would need 10 hours
to eat all the bananas (which exceeds h=9), thus the minimum eating rate is 2.

Example 2:

Input: piles = [25,10,23,4], h = 4

Output: 25
*/

import java.util.Arrays;

public class ProblemNC12 {
    public static void main(String[] args) {
        SolutionNC12 solution = new SolutionNC12();

        System.out.println(solution.minEatingSpeed(new int[]{1, 4, 3, 2}, 9));
    }

}

class SolutionNC12 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int output = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / mid);
            }

            if (totalTime <= h) {
                output = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return output;
    }
}