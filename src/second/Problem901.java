package second;
/*
There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.

Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

Example 1:

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
Example 2:

Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4
Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
Example 3:

Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class Problem901 {
    public static void main(String[] args) {
        Solution901 solution = new Solution901();

        Solution901.StockSpanner stockSpanner = solution.new StockSpanner();
        stockSpanner.next(100); // return 1
        stockSpanner.next(80);  // return 1
        stockSpanner.next(60);  // return 1
        stockSpanner.next(70);  // return 2
        stockSpanner.next(60);  // return 1
    }
}

class Solution901 {
    class StockSpanner {

        Deque<int[]> stocks = new ArrayDeque<>();

        public StockSpanner() {

        }

        public int next(int price) {
            int res = 1;

            while (!stocks.isEmpty() && stocks.peek()[0] <= price) {
                res += stocks.pollFirst()[1];
            }

            stocks.offerFirst(new int[]{price, res});

            return res;
        }
    }
}
