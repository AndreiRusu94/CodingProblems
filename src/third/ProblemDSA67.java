package third;
/*
A Java program for Prim's Minimum Spanning Tree (MST)
algorithm. The program is for adjacency list
representation of the graph

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ProblemDSA67 {
    public static void main(String[] args) {
        SolutionDSA67 solution = new SolutionDSA67();

        int[][] city = {
                {0, 1, 1}, {0, 2, 2}, {0, 3, 3}, {0, 4, 4},
                {1, 2, 5}, {1, 4, 7}, {2, 3, 6}
        };

        System.out.println(solution.findMST(city, 5));

        int[][] city2 = {
                {0, 1, 1}, {0, 2, 1}, {0, 3, 100},
                {1, 2, 1}, {3, 4, 2}, {3, 5, 2}, {4, 5, 2}
        };
        System.out.println(solution.findMST(city2, 6));
    }
}

class SolutionDSA67 {

    public int findMST(int[][] edges, int n) {
        List<List<List<Integer>>> adj = constructAdj(edges, n);
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));

        List<Integer> start = new ArrayList<>();
        start.add(0);
        start.add(0);
        pq.add(start);
        boolean[] inMST = new boolean[n + 1];
        int mstCost = 0;

        while (!pq.isEmpty()) {
            List<Integer> curr = pq.poll();
            int v = curr.get(0);
            int weight = curr.get(1);

            if (inMST[v]) {
                continue;
            }

            inMST[v] = true;
            mstCost += weight;
            for (List<Integer> neighbour : adj.get(v)) {
                if (!inMST[neighbour.get(0)]) {
                    pq.add(neighbour);
                }
            }
        }

        return mstCost;
    }

    private List<List<List<Integer>>> constructAdj(int[][] edges, int n) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int v = edge[0];
            int u = edge[1];
            int wh = edge[2];

            List<Integer> e1 = new ArrayList<>();
            e1.add(u);
            e1.add(wh);
            adj.get(v).add(e1);

            List<Integer> e2 = new ArrayList<>();
            e2.add(v);
            e2.add(wh);
            adj.get(u).add(e2);
        }

        return adj;
    }


}