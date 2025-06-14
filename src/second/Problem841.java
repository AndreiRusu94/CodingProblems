package second;
/*
There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.

Example 1:

Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation:
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.
Example 2:

Input: rooms = [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem841 {
    public static void main(String[] args) {
        Solution841 solution = new Solution841();
        List<List<Integer>> rooms = List.of(List.of(1), List.of(2), List.of(3), List.of());

        System.out.println(solution.canVisitAllRooms(rooms));
    }
}


class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        visitAvailableRooms(graph, visited, rooms, 0);

        for (int i = 0; i < rooms.size(); i++) {
            if (!visited.contains(i)) {
                return false;
            }
        }
        return true;
    }

    private void visitAvailableRooms(Map<Integer, List<Integer>> graph, Set<Integer> visited, List<List<Integer>> rooms, int room) {
        if (visited.contains(room)) {
            return;
        }

        visited.add(room);

        for (Integer key : rooms.get(room)) {
            graph.computeIfAbsent(room, k -> new ArrayList<>()).add(key);
            visitAvailableRooms(graph, visited, rooms, key);
        }
    }
}


