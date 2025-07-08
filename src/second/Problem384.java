package second;
/*
Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.

Example 1:

Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                       // Any permutation of [1,2,3] must be equally likely to be returned.
                       // Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
*/

import java.util.Arrays;
import java.util.Random;

public class Problem384 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2};
        Solution384 solution = new Solution384(nums);

        System.out.println(Arrays.toString(solution.shuffle()));
    }
}


class Solution384 {
    private int[] original;
    private int originalSize;

    public Solution384(int[] nums) {
        originalSize = nums.length;
        original = Arrays.copyOf(nums, originalSize);
    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        int[] shuffled = Arrays.copyOf(original, originalSize);

        int leftSize = originalSize;
        for (int i = originalSize - 1; i >= 0; i--) {
            Random random = new Random();
            int j = random.nextInt(leftSize);
            int temp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = temp;

            leftSize--;
        }

        return shuffled;
    }
}


