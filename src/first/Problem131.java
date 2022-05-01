package first;
/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

  Example:

    Input: "aab"
    Output:
    [
      ["aa","b"],
      ["a","a","b"]
    ]
*/

import java.util.ArrayList;
import java.util.List;

public class Problem131 {
    public static void main(String[] args) {
        Solution131 solution = new Solution131();

        System.out.println(solution.partition("aab"));
    }
}

class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();

        backtrack(s, 0, output, new ArrayList<>());

        return output;
    }

    private void backtrack(String s, int pos, List<List<String>> output, List<String> tempList) {
        if (pos == s.length()) {
            output.add(new ArrayList<>(tempList));
        } else {
            for (int i = pos; i < s.length(); i++) {
                if (isPalindrome(s, pos, i)) {
                    tempList.add(s.substring(pos, i + 1));
                    backtrack(s, i + 1, output, tempList);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
