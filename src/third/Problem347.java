package third;
/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
Output: [1,2]

*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem347 {
    public static void main(String[] args) {
        Solution347 solution = new Solution347();

        int[] nums = {9, 4, 4, 4, 3, 0, 7, 0, 1};
        System.out.println(Arrays.toString(solution.topKFrequent(nums, 3)));
    }
}

class Solution347 {

    public record Frequency(int number, int frequency) {}

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Frequency> pq = new PriorityQueue<>(Comparator.comparingInt(Frequency::frequency).reversed());
        HashMap<Integer, Integer> numToFreq = new HashMap<>();

        for (int i : nums) {
            numToFreq.put(i, numToFreq.getOrDefault(i, 0) + 1);
            pq.add(new Frequency(i, numToFreq.get(i)));
        }

        Set<Integer> used = new HashSet<>();
        int[] output = new int[k];
        while (!pq.isEmpty()) {
            Frequency fq = pq.poll();
            if (!used.contains(fq.number)) {
                used.add(fq.number);
                k--;
                output[k] = fq.number;
            }

            if (k == 0) {
                return output;
            }
        }

        return output;
    }

}

