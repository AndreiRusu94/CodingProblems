package third;
/*
Given a stack of integers, sort it in ascending order using another temporary stack.

Examples:

Input: [34, 3, 31, 98, 92, 23]
Output: [3, 23, 31, 34, 92, 98]
Explanation: After Sorting the given array it would be look like as [3, 23, 31, 34, 92, 98]

Input: [3, 5, 1, 4, 2, 8]
Output: [1, 2, 3, 4, 5, 8]
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class ProblemDSA41 {
    public static void main(String[] args) {
        SolutionDSA41 solution = new SolutionDSA41();

        Deque<Integer> input = new ArrayDeque<>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

        var output = solution.sortstack(input);

        for (var e : output) {
            System.out.print(e + " ");
        }
    }
}

class SolutionDSA41 {
    public Deque<Integer> sortstack(Deque<Integer> input) {
        if (input.isEmpty()) {
            return input;
        }

        Deque<Integer> output = new ArrayDeque<>();
        while (!input.isEmpty()) {
            int temp = input.pop();

            while (!output.isEmpty() && output.peek() < temp) {
                input.push(output.pop());
            }

            output.push(temp);
        }

        return output;
    }


}