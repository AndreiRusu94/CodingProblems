package third;
/*
We define str = [s, n] as the string str which consists of the string s concatenated n times.

For example, str == ["abc", 3] =="abcabcabc".
We define that string s1 can be obtained from string s2 if we can remove some characters from s2 such that it becomes s1.

For example, s1 = "abc" can be obtained from s2 = "abdbec" based on our definition by removing the bolded underlined characters.
You are given two strings s1 and s2 and two integers n1 and n2. You have the two strings str1 = [s1, n1] and str2 = [s2, n2].

Return the maximum integer m such that str = [str2, m] can be obtained from str1.

Example 1:

Input: s1 = "acb", n1 = 4, s2 = "ab", n2 = 2
Output: 2
Example 2:

Input: s1 = "acb", n1 = 1, s2 = "acb", n2 = 1
Output: 1

*/

public class Problem466 {
    public static void main(String[] args) {
        Solution466 solution = new Solution466();

        System.out.println(solution.getMaxRepetitions("acb", 4, "ab", 2));
    }
}

class Solution466 {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int count1 = 0, count2 = 0, i = 0, j = 0;
        char[] array1 = s1.toCharArray(), array2 = s2.toCharArray();

        while (count1 < n1) {
            if (array1[i] == array2[j]) {
                j++;
                if (j == s2.length()) {
                    j = 0;
                    count2++;
                }
            }
            i++;
            if (i == s1.length()) {
                i = 0;
                count1++;
            }
        }

        return count2 / n2;
    }

}

