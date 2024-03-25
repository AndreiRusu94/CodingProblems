package second;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
 */

public class Problem14 {

    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}

class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
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

                if (!currentChar.equals(strs[j].substring(i, i + 1))) {
                    return output.toString();
                }
            }

            output.append(currentChar);
        }

        return output.toString();
    }
}
