package second;

/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */

public class Problem28 {

    public static void main(String[] args) {
        Solution28 solution =  new Solution28();
        System.out.println(solution.strStr("sadbutsad", "sad"));
    }
}

class Solution28 {
    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();

        for (int i = 0; i <= haystack.length() - needleLength; i++) {
            boolean valid = true;
            for (int j = 0; j < needleLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    valid = false;
                    break;
                }
            }

            if (valid == true) {
                return i;
            }
        }

        return -1;
    }
}
