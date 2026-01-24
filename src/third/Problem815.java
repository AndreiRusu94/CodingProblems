package third;
/*
You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.

For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.

Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.

Example 1:

Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
Output: 2
Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
Example 2:

Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
Output: -1

*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem815 {
    public static void main(String[] args) {
        Solution815 solution = new Solution815();

        System.out.println(solution.numBusesToDestination(new int[][]{
                {1, 2, 7},
                {3, 6, 7}
        }, 1, 6));
    }
}

class Solution815 {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> toRoutes = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int j : routes[i]) {
                if (!toRoutes.containsKey(j)) {
                    toRoutes.put(j, new HashSet<>());
                }
                toRoutes.get(j).add(i);
            }
        }

        if (source == target) {
            return 0;
        }

        if (!toRoutes.containsKey(target) || !toRoutes.containsKey(source)) {
            return -1;
        }

        Deque<int[]> bfs = new ArrayDeque<>();
        bfs.offer(new int[]{source, 0});
        Set<Integer> seen = new HashSet<>();
        seen.add(source);
        boolean[] seenRoutes = new boolean[routes.length];

        while (!bfs.isEmpty()) {
            int stop = bfs.peek()[0], bus = bfs.peek()[1];
            bfs.poll();
            if (stop == target) {
                return bus;
            }

            for (int i : toRoutes.get(stop)) {
                if (seenRoutes[i]) {
                    continue;
                }

                for (int j : routes[i]) {
                    if (!seen.contains(j)) {
                        seen.add(j);
                        bfs.offer(new int[]{j, bus + 1});
                    }
                }
                seenRoutes[i] = true;
            }
        }

        return -1;

    }

}

