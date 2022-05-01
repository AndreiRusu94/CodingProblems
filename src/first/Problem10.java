package first;
/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

  Example:

    Given array nums = [-1, 0, 1, 2, -1, -4],

    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
 */

public class Problem10 {
    public static void main(String[] args) {
        Solution10 solution = new Solution10();

        System.out.println(solution.isMatch("aaaaaa"
                ,"aaaa.*"));
    }
}

class Solution10 {
    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }

        if (isEmpty(s) || isEmpty(p)) {
            return false;
        }

        if ("*".equals(p.substring(0, 1))) {
            return false;
        }

        int inputIndex = 0;
        for (int patternIndex = 0; patternIndex < p.length(); patternIndex++) {
            String patternChar = p.substring(patternIndex, patternIndex + 1);

            String inputChar;
            if (inputIndex < s.length()) {
                inputChar = s.substring(inputIndex, inputIndex + 1);
            } else {
                return false;
            }

            if (isPrecedingMatchSymbol(patternChar)) {
                String previousChar = p.substring(patternIndex - 1, patternIndex);

                if (isAnyMatchSymbol(previousChar)) {
                    if (patternIndex == p.length() - 1) {
                        return true;
                    } else {
                        patternIndex++;
                        inputIndex++;
                        String nextCharInPattern = p.substring(patternIndex, patternIndex + 1);

                        if (inputIndex < s.length()) {
                            inputChar = s.substring(inputIndex, inputIndex + 1);
                        } else {
                            return false;
                        }

                        while (!nextCharInPattern.equals(inputChar)) {
                            if (inputIndex < s.length()) {
                                inputChar = s.substring(inputIndex, inputIndex + 1);
                            } else {
                                return false;
                            }

                            inputIndex++;
                        }
                    }
                } else {
                    while (previousChar.equals(inputChar)) {
                        inputIndex++;
                        if (inputIndex < s.length()) {
                            inputChar = s.substring(inputIndex, inputIndex + 1);
                        } else {
                            inputIndex--;
                            inputChar = s.substring(s.length() - 1);
                            break;
                        }
                    }
                }
            } else {
                if (isAnyMatchSymbol(patternChar)) {
                    inputIndex++;
                } else {
                    if (patternIndex + 1 < p.length()) {
                        String nextCharInPattern = p.substring(patternIndex + 1, patternIndex + 2);

                        if (!isPrecedingMatchSymbol(nextCharInPattern)) {
                            if (!patternChar.equals(inputChar)) {
                                return false;
                            } else {
                                inputIndex++;
                            }
                        }
                    }
                }
            }
        }

        if (inputIndex >= s.length() - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public boolean isAnyMatchSymbol(String s) {
        return ".".equals(s);
    }

    public boolean isPrecedingMatchSymbol(String s) {
        return "*".equals(s);
    }

}