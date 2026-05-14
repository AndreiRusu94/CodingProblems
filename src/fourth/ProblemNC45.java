package fourth;
/*
You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.

You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.

Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.

Example 1:

Input: prices = [10,1,5,6,7,1]

Output: 6
Explanation: Buy prices[1] and sell prices[4], profit = 7 - 1 = 6.

Example 2:

Input: prices = [10,8,7,5,2]

Output: 0
Explanation: No profitable transactions can be made, thus the max profit is 0.
*/

public class ProblemNC45 {
    public static void main(String[] args) {
        SolutionNC45 solution = new SolutionNC45();
        System.out.println(solution.maxProfit(new int[]{2, 4, 3, 2, 2, 5, 1, 4}));
    }
}

class SolutionNC45 {

    public int maxProfit(int[] prices) {
        int l = 0, maxProfit = 0;
        for (int r = 1; r < prices.length; r++) {
            maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            if (prices[l] >= prices[r]) {
                l = r;
            }
        }

        return maxProfit;
    }

}

