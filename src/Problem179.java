/*
Given a list of non negative integers, arrange them such that they form the largest number.

  Example 1:

    Input: [10,2]
    Output: "210"

  Example 2:

    Input: [3,30,34,5,9]
    Output: "9534330"
*/

import java.util.Arrays;

public class Problem179 {
    public static void main(String[] args) {
        Solution179 solution = new Solution179();

        int[] nums = new int[]{2, 11, 10, 35, 30};

        System.out.println(solution.largestNumber(nums));
    }
}


class Solution179 {
    private static final String ZERO = "0";

    public String largestNumber(int[] nums) {
        String[] numsAsString = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numsAsString[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsAsString, (a, b) -> {
            String firstOrder = a + b;
            String secondOrder = b + a;

            return secondOrder.compareTo(firstOrder);
        });

        if (ZERO.equals(numsAsString[0])) {
            return ZERO;
        }

        StringBuilder largestNumberString = new StringBuilder();

        for (String numAsString : numsAsString) {
            largestNumberString.append(numAsString);
        }

        return largestNumberString.toString();
    }
}


