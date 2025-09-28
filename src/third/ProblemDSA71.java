package third;
/*
Given a 2d matrix cost[][] of size n where cost[i][j] denotes the cost of moving from city i to city j. The task is to complete a tour from city 0
(0-based index) to all other cities such that we visit each city exactly once and then at the end come back to city 0 at minimum cost.

Note the difference between Hamiltonian Cycle and TSP. The Hamiltonian cycle problem is to find if there exists a tour that visits every city
exactly once. Here we know that Hamiltonian Tour exists (because the graph is complete) and in fact, many such tours exist, the problem is to find
 a minimum weight Hamiltonian Cycle.

Examples:

Input: cost[][] = [[0, 111], [112, 0]]
Output: 223
Explanation: We can visit 0->1->0 and cost = 111 + 112 = 223.

Input: cost[][] = [[0, 1000, 5000], [5000, 0, 1000], [1000, 5000, 0]]
Output: 3000
Explanation: We can visit 0->1->2->0 and cost = 1000 + 1000 + 1000 = 3000.

The given graph is a complete graph, meaning there is an edge between every pair of nodes. A naive approach to solve this problem is to generate
 all permutations of the nodes, and calculate the cost for each permutation, and select the minimum cost among them.

An important observation in the Traveling Salesman Problem (TSP) is that the choice of the starting node does not affect the solution.
This is because the optimal path forms a cyclic tour. For example, if the optimal tour is a1→a2→a3→a4→a1, starting from any other node, such as
a2, results in the equivalent tour a2→a3→a4→a1→a2 with same total cost.

To simplify the problem, we can fix one node (e.g., node 1) as the starting point and only consider permutations of the remaining nodes.

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProblemDSA71 {
    public static void main(String[] args) {
        SolutionDSA71 solution = new SolutionDSA71();

        int[][] cost = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};

        int res = solution.tsp(cost);
        System.out.println(res);
    }
}

class SolutionDSA71 {

    public int tsp(int[][] cost) {
        int n = cost.length;
        List<Integer> nodes = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            nodes.add(i);
        }

        int minCost = Integer.MAX_VALUE;

        do {
            int currCost = 0;
            int currNode = 0;

            for (int i = 0; i < nodes.size(); i++) {
                currCost += cost[currNode][nodes.get(i)];
                currNode = nodes.get(i);
            }

            currCost += cost[currNode][0];
            minCost = Math.min(minCost, currCost);
        } while (nextPermutation(nodes));

        return minCost;
    }

    private boolean nextPermutation(List<Integer> nodes) {
        int i = nodes.size() - 2;

        // Find the first pair where nodes[i] < nodes[i + 1]
        while (i >= 0 && nodes.get(i) >= nodes.get(i + 1)) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = nodes.size() - 1;
        // Find the smallest element larger than nodes[i] to the right
        while (nodes.get(i) >= nodes.get(j)) {
            j--;
        }

        Collections.swap(nodes, i, j);
        Collections.reverse(nodes.subList(i + 1, nodes.size()));

        return true;
    }

}

