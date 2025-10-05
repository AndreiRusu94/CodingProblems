package third;
/*
Given an array job[], where each element represents the time required to complete a specific job. There are k identical assignees available to
complete these jobs, and each assignee takes t units of time to complete one unit of a job. The task is to determine the minimum time required
to complete all jobs while following these constraints:

Each assignee can only be assigned jobs that are contiguous in the given array. For example, an assignee can be assigned jobs (job[1], job[2],
job[3]) but not (job[1], job[3]) (skipping job[2]). A single job cannot be divided between two assignees. Each job must be assigned to exactly one
assignee.
Examples:

Input: job[] = {10, 7, 8, 12, 6, 8}, k = 4, t = 5
Output: 75
Explanation: The minimum time required to finish all the jobs is 75.

Assign {10} to the first assignee. so the total time is 10*5 = 50
Assign {7, 8} to the second assignee. so the total time is 15*5 = 75
Assign {12} to the third assignee. so the total time is 12*5 = 60
Assign {6, 8} to the fourth assignee. so the total time is 14*5 = 70
Maximum time taken by any assignee is (15 * 5) = 75.

Input: job[] = {4, 5, 10}, k = 2, t = 5
Output: 50
Explanation: The minimum time required to finish all the jobs is 50.

Assign {4, 5} to the first assignee... so the total time is 9*5 = 45
Assign {10} to the second assignee. so the total time is 10*5 = 50
Maximum time taken by any assignee is (10* 5) = 50.
*/

public class ProblemDSA81 {
    public static void main(String[] args) {
        SolutionDSA81 solution = new SolutionDSA81();

        int[] job = {10, 7, 8, 12, 6, 8};
        int k = 4, t = 5;

        System.out.println(solution.findMinTime(job, k, t));
    }
}

class SolutionDSA81 {

    public int findMinTime(int[] job, int k, int t) {
        int start = 0, end = 0, output;

        for (int i : job) {
            end += i;
            start = Math.max(start, i);
        }

        output = end;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isPossible(job, mid, k)) {
                output = Math.min(output, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return output * t;
    }

    private boolean isPossible(int[] job, int t, int k) {
        int count = 1;
        int curr = 0;

        for (int i = 0; i < job.length; ) {
            if (curr + job[i] > t) {
                count++;
                curr = 0;
            } else {
                curr += job[i];
                i++;
            }
        }

        return (count <= k);
    }
}

