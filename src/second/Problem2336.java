package second;

/*
You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].

Implement the SmallestInfiniteSet class:

SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
int popSmallest() Removes and returns the smallest integer contained in the infinite set.
void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.

Example 1:

Input
["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
[[], [2], [], [], [], [1], [], [], []]
Output
[null, null, 1, 2, 3, null, 1, 4, 5]

Explanation
SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
                                   // is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.


Constraints:

1 <= num <= 1000
At most 1000 calls will be made in total to popSmallest and addBack.
*/

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem2336 {

    public static void main(String[] args) {
        Solution2336 solution2336 = new Solution2336();
        solution2336.addBack(2);
        solution2336.popSmallest();
        solution2336.popSmallest();
        solution2336.popSmallest();
        solution2336.addBack(1);

    }
}

class Solution2336 {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Set<Integer> removed = new HashSet<>();
    int current = 1;

    public Solution2336() {

    }

    public int popSmallest() {
        pq.offer(current++);
        removed.add(pq.peek());
        return pq.poll();
    }

    public void addBack(int num) {
        if (removed.contains(num)) {
            pq.offer(num);
            removed.remove(num);
        }
    }
}