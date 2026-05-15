package fourth;
/*
Given an array of integers numbers that is sorted in non-decreasing order.

Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.

There will always be exactly one valid solution.

Your solution must use O(1) additional space.

Example 1:

Input: numbers = [1,2,3,4], target = 3

Output: [1,2]
Explanation:
The sum of 1 and 2 is 3. Since we are assuming a 1-indexed array, index1 = 1, index2 = 2. We return [1, 2].
*/

import java.util.Arrays;

public class ProblemNC49 {
    public static void main(String[] args) {
        SolutionNC49 solution = new SolutionNC49();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 4, 5, 8}, 9)));
    }
}

class SolutionNC49 {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            if (numbers[l] + numbers[r] < target) {
                l++;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }

        return new int[0];
    }

}

