/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

  Example 1:
    Input: ["flower","flow","flight"]
    Output: "fl"

  Example 2:
    Input: ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
 */

public class Problem12 {
    public static void main(String[] args) {
        Solution12 solution = new Solution12();

        String[] input = {"dog","racecar","car"};
        System.out.println(solution.longestCommonPrefix(input));
    }
}

class Solution12 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            String currentChar = strs[0].substring(i, i+1);

            for (int j = 1; j < strs.length; j++) {
                if (i + 1 > strs[j].length()) {
                    return output.toString();
                }

                if (!currentChar.equals(strs[j].substring(i, i+1))) {
                    return output.toString();
                }
            }

            output.append(currentChar);
        }

        return output.toString();
    }
}