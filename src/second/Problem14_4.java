package second;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
 */

public class Problem14_4 {

    public static void main(String[] args) {
        Solution14_4 solution = new Solution14_4();
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}

class Solution14_4 {
    public String longestCommonPrefix(String[] strs) {
        String compareTo = strs[0];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < compareTo.length(); i++) {
            var charToCompare = compareTo.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != charToCompare) {
                    return sb.toString();
                }
            }

            sb.append(charToCompare);
        }

        return sb.toString();
    }
}
