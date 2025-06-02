package second;
/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
*/

import java.util.HashSet;
import java.util.Set;

public class Problem547 {
    public static void main(String[] args) {
        Solution547 solution = new Solution547();
        int[][] isConnected = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println(solution.findCircleNum(isConnected));
    }
}


class Solution547 {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int provinces = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                visit(isConnected, visited, i);
                provinces++;
            }
        }

        return provinces;
    }

    private void visit(int[][] isConnected, Set<Integer> visited, int city) {
        for (int j = 0; j < isConnected.length; j++) {
            if (city == j) {
                continue;
            }

            if (isConnected[city][j] == 1 && !visited.contains(j)) {
                visited.add(j);
                visit(isConnected, visited, j);
            }
        }
    }
}


