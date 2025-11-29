package third;
/*
Dijkstra’s Algorithm using Min Heap

Given a weighted undirected graph represented as an edge list and a source vertex src, find the shortest path distances from the source vertex
to all other vertices in the graph. The graph contains V vertices, numbered from 0 to V - 1.

Note: The given graph does not contain any negative edge.

Examples:

Input: src = 0, V = 5, edges[][] = [[0, 1, 4], [0, 2, 8], [1, 4, 6], [2, 3, 2], [3, 4, 10]]

1
Graph with 5 node
Output:  0 4 8 10 10
Explanation:  Shortest Paths:
0 to 1 = 4. 0 → 1
0 to 2 = 8. 0 → 2
0 to 3 = 10. 0 → 2 → 3
0 to 4 = 10. 0 → 1 → 4

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ProblemDSA63 {
    public static void main(String[] args) {
        SolutionDSA63 solution = new SolutionDSA63();

        int v = 5;
        int src = 0;

        int[][] edges = {
                {0, 1, 4}, {0, 2, 8}, {1, 4, 6},
                {2, 3, 2}, {3, 4, 10}
        };

        System.out.println(Arrays.toString(solution.dijkstra(edges, v, src)));
    }
}

class SolutionDSA63 {

    public int[] dijkstra(int[][] edges, int v, int src) {
        List<List<List<Integer>>> adj = constructAdj(edges, v);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        int[] start = new int[]{0, src};
        pq.add(start);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[1];

            for (List<Integer> neighbour : adj.get(u)) {
                int V = neighbour.get(0);
                int weight = neighbour.get(1);

                if (dist[V] > dist[u] + weight) {
                    dist[V] = dist[u] + weight;
                    pq.add(new int[]{dist[V], V});
                }
            }
        }

        return dist;
    }

    private List<List<List<Integer>>> constructAdj(int[][] edges, int v) {
        List<List<List<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int s = edge[0];
            int t = edge[1];
            int w = edge[2];

            List<Integer> e1 = new ArrayList<>();
            e1.add(t);
            e1.add(w);
            adj.get(s).add(e1);

            List<Integer> e2 = new ArrayList<>();
            e2.add(s);
            e2.add(w);
            adj.get(t).add(e2);
        }

        return adj;
    }

}