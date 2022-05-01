package first;
/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

  Example 1:

    Input: haystack = "hello", needle = "ll"
    Output: 2

  Example 2:

    Input: haystack = "aaaaa", needle = "bba"
    Output: -1
 */

public class Problem28 {
    public static void main(String[] args) {
        Solution28 solution = new Solution28();

        String haystack = "reqababab", needle = "ab";
        System.out.println(solution.strStr(haystack, needle));
    }
}

class Solution28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if (haystack.equals(needle)) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) {
                return -1;
            }

            for (int j = 0; j < needle.length(); j++) {
                if (!haystack.substring(i+j, i+j+1).equals(needle.substring(j, j+1))) {
                    break;
                } else {
                    if (j == needle.length() - 1) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }
}