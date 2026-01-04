package third;
/*
Dijkstra's Algorithm to find the shortest path from a source vertex to all other vertices in a weighted graph.
Given a graph represented as an edge list, the number of vertices v, and a source vertex src, implement Dijkstra's algorithm to find the shortest path from the source
vertex to all other vertices.
 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem1405 {
    public static void main(String[] args) {
        Solution1405 solution = new Solution1405();

        int v = 5;
        int src = 0;

        int[][] edges = {
                {0, 1, 4}, {0, 2, 8}, {1, 4, 6},
                {2, 3, 2}, {3, 4, 10}
        };

        System.out.println(Arrays.toString(solution.dijkstra(v, edges, src)));
    }
}


class Solution1405 {
    public int[] dijkstra(int v, int[][] edges, int src) {
        List<List<List<Integer>>> adj = constructAdj(v, edges);

        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int s = curr[0];
            int d = curr[1];

            for (List<Integer> neighbour : adj.get(s)) {
                int t = neighbour.get(0);
                int w = neighbour.get(1);

                if (dist[t] > d + w) {
                    pq.add(new int[]{t, d + w});
                    dist[t] = d + w;
                }
            }
        }

        return dist;
    }

    private List<List<List<Integer>>> constructAdj(int v, int[][] edges) {
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


