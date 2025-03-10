package second;
/*
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}

Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

Example 1:


Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 */

public class Problem133 {
    public static void main(String[] args) {
        Solution133 solution = new Solution133();

        int[] input = {1, 2, 3};
        Node.displayListNode(solution.cloneGraph(Node.createListNode(input)));
    }
}

/**
// Definition for a Node.
 class Node {
     public int val;
     public List<Node> neighbors;
     public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
     }
     public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
     }
     public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
     }
 }
*/

class Solution133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Node[] visited = new Node[101];
        return dfs(node, visited);
    }

    private Node dfs(Node node, Node[] visited) {
        if (visited[node.val] != null) {
            return visited[node.val];
        }

        visited[node.val] = new Node(node.val);
        for (Node n : node.neighbors) {
            visited[node.val].neighbors.add(dfs(n, visited));
        }
        return visited[node.val];
    }
}