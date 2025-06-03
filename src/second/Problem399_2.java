package second;
/*
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem399_2 {
    public static void main(String[] args) {
        Solution399_2 solution = new Solution399_2();

        List<List<String>> equations = new ArrayList<>();
        equations.add(List.of("a", "b"));
        equations.add(List.of("b", "c"));

        double[] values = new double[]{2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(List.of("a", "c"));
        queries.add(List.of("b", "a"));
        queries.add(List.of("a", "e"));
        queries.add(List.of("a", "a"));
        queries.add(List.of("x", "x"));

        System.out.println(Arrays.toString(solution.calcEquation(equations, values, queries)));
    }
}


class Solution399_2 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        var output = new double[queries.size()];
        Map<String, Map<String, Double>> graph = createGraph(equations, values);

        for (int i = 0; i < queries.size(); i++) {
            output[i] = getPathWeight(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }
        return output;
    }

    public Map<String, Map<String, Double>> createGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            var equation = equations.get(i);
            String u = equation.get(0);
            String v = equation.get(1);

            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1 / values[i]);
        }

        return graph;
    }

    public double getPathWeight(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(start)) {
            return -1.0;
        }

        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);

        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double productWeight = getPathWeight(neighbor.getKey(), end, visited, graph);
                if (productWeight != -1.0) {
                    return productWeight * neighbor.getValue();
                }
            }
        }

        return -1.0;
    }


}


