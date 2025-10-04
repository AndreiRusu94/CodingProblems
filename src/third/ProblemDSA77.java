package third;
/*
Given two arrays, deadline[] and profit[], where deadline[i] is the last time unit by which the i-th job must be completed, and profit[i] is the
profit earned from completing it.
Each job takes 1 unit time, and only one job can be scheduled at a time. A job earns profit only if finished within its deadline. Find the number
of jobs completed and maximum profit.

Examples:

Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
Output: [2, 60]
Explanation: Job 1 (profit 20, deadline 4) can be scheduled. Among the three jobs with deadline 1, only one fits, so we pick the highest profit
(40). Hence, 2 jobs with total profit = 60.

Input: deadline[] = [2, 1, 2, 1, 1], profit[] = [100, 19, 27, 25, 15]
Output: [2, 127]
Explanation: Picking the job with profit 100 (deadline 2) and the job with profit 27 (deadline 2); they can occupy the two available slots before
deadline 2. Thus, 2 jobs are scheduled for a maximum total profit of 127.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ProblemDSA77 {
    public static void main(String[] args) {
        SolutionDSA77 solution = new SolutionDSA77();

        int[] deadline = {2, 1, 2, 1, 1};
        int[] profit = {100, 19, 27, 25, 15};
        List<Integer> result = solution.jobSequencing(deadline, profit);
        System.out.println(result.get(0) + " " + result.get(1));
    }
}

class SolutionDSA77 {

    public List<Integer> jobSequencing(int[] deadline, int[] profit) {
        List<int[]> jobs = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = deadline.length;
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{deadline[i], profit[i]});
        }

        jobs.sort(Comparator.comparingInt(a -> a[0]));

        List<Integer> output = new ArrayList<>(Arrays.asList(0, 0));

        for (int i = 0; i < n; i++) {
            int[] job = jobs.get(i);

            if (job[0] > pq.size()) {
                pq.add(job[1]);
            } else if (!pq.isEmpty() && pq.peek() < job[1]) {
                pq.poll();
                pq.add(job[1]);
            }
        }

        while (!pq.isEmpty()) {
            output.set(0, output.get(0) + 1);
            output.set(1, output.get(1) + pq.poll());
        }

        return output;
    }

}

