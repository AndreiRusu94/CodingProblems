package fourth;
/*
Given a string s, return true if it is a palindrome, otherwise return false.

A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.

Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).

Example 1:

Input: s = "Was it a car or a cat I saw?"

Output: true
Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.

Example 2:

Input: s = "tab a cat"

Output: false
*/

import java.util.ArrayList;
import java.util.List;

public class ProblemNC48 {
    public static void main(String[] args) {
        SolutionNC48 solution = new SolutionNC48();
        System.out.println(solution.findClosestElements(new int[]{2, 4, 5, 8}, 2, 6));
    }
}

class SolutionNC48 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        l = l - 1;
        r = l + 1;

        while (r - l - 1 < k) {
            if (l < 0) {
                r++;
            } else if (r >= arr.length) {
                l--;
            } else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                l--;
            } else {
                r++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = l + 1; i < r; i++) {
            result.add(arr[i]);
        }

        return result;
    }

}

