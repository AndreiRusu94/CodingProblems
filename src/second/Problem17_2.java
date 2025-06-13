package second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */

public class Problem17_2 {

    public static void main(String[] args) {
        Solution17_2 solution = new Solution17_2();
        System.out.println(solution.letterCombinations("23"));
    }
}

class Solution17_2 {
    public static Map<String, String> digitToLetters;

    static {
        digitToLetters = new HashMap<>();
        digitToLetters.put("2", "abc");
        digitToLetters.put("3", "def");
        digitToLetters.put("4", "ghi");
        digitToLetters.put("5", "jkl");
        digitToLetters.put("6", "mno");
        digitToLetters.put("7", "pqrs");
        digitToLetters.put("8", "tuv");
        digitToLetters.put("9", "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return output;
        }

        backtracking(digits, output, "", 0);
        return output;
    }

    public void backtracking(String digits, List<String> output, String current, int currentDigit) {
        if (digits.length() == current.length()) {
            output.add(current);
            return;
        }

        String s = digits.substring(currentDigit, currentDigit + 1);
        for (int j = 0; j < digitToLetters.get(s).length(); j++) {
            backtracking(digits, output, current + digitToLetters.get(s).substring(j, j + 1), currentDigit + 1);
        }
    }
}