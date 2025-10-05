package third;
/*
The three stacks s1, s2 and s3, each containing positive integers, are given. The task is to find the maximum possible equal sum that can be
achieved by removing elements from the top of the stacks. Elements can be removed from the top of each stack, but the final sum of the remaining
elements in all three stacks must be the same. The goal is to determine the maximum possible equal sum that can be achieved after removing elements.

Note: The stacks are represented as arrays, where the first index of the array corresponds to the top element of the stack.

Examples:

Input: s1 = [3, 2, 1, 1, 1], s2 = [2, 3, 4], s3 = [1, 4, 2, 5]
Output: 5
Explanation: We can pop 2 elements from the 1st stack, 1 element from the 2nd stack and 2 elements from the 3rd stack.
*/

import java.util.ArrayList;
import java.util.List;

public class ProblemDSA80 {
    public static void main(String[] args) {
        SolutionDSA80 solution = new SolutionDSA80();

        List<Integer> s1 = new ArrayList<>();
        s1.add(3);
        s1.add(2);
        s1.add(1);
        s1.add(1);
        s1.add(1);

        List<Integer> s2 = new ArrayList<>();
        s2.add(4);
        s2.add(3);
        s2.add(2);

        List<Integer> s3 = new ArrayList<>();
        s3.add(1);
        s3.add(1);
        s3.add(4);
        s3.add(1);


        System.out.println(solution.maxSum(s1, s2, s3));
    }
}

class SolutionDSA80 {

    public int maxSum(List<Integer> s1, List<Integer> s2, List<Integer> s3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i : s1) {
            sum1 += i;
        }

        for (int i : s2) {
            sum2 += i;
        }

        for (int i : s3) {
            sum3 += i;
        }

        int idx1 = 0, idx2 = 0, idx3 = 0;
        while (s1.size() != idx1 && s2.size() != idx2 && s3.size() != idx3) {
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }

            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= s1.get(idx1++);
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= s2.get(idx2++);
            } else {
                sum3 -= s3.get(idx3++);
            }
        }

        return 0;
    }
}

