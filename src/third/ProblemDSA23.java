package third;
/*
Given two strings in lowercase, the task is to make them anagrams. The only allowed operation is to remove a character from any string.
Find the minimum number of characters to be deleted to make both the strings anagram. Two strings are called anagrams of each other if one of
them can be converted into another by rearranging its letters.

Examples :

Input : s1 = "bcadeh", s2 = "hea"
Output: 3
Explanation: We need to remove b, c and d from s1.

Input : s1 = "cddgk", s2 = "gcda"
Output: 3
Explanation: Remove one occurrence of d and k from s1 and one occurrence of a from s2.

Input : s1 = "bca", s2 = "acb"
Output: 0
Explanation: Strings are already anagrams.
*/

public class ProblemDSA23 {
    public static void main(String[] args) {
        SolutionDSA23 solution = new SolutionDSA23();

        System.out.println(solution.remAnagram("cddgk", "gcda"));
    }
}

class SolutionDSA23 {

    public int remAnagram(String s1, String s2) {
        int[] count = new int[26];
        int result = 0;

        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            count[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            result += Math.abs(count[i]);
        }

        return result;
    }

}
