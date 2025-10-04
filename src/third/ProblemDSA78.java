package third;
/*
Given a numeric string s, find the lexicographically largest string by swapping at most one pair of characters.

Note:  Leading zeros are not allowed.

Examples:

Input: s = "768"
Output: 867
Explanation: Swapping the 1st and 3rd characters (7 and 8 respectively), gives the lexicographically largest string.

Input: s = "333"
Output: 333
Explanation: Performing any swaps gives the same result i.e 333.

*/

public class ProblemDSA78 {
    public static void main(String[] args) {
        SolutionDSA78 solution = new SolutionDSA78();

        System.out.println(solution.largestSwap("789"));
    }
}

class SolutionDSA78 {

    public String largestSwap(String s) {
        char[] letters = s.toCharArray();

        int l = -1, r = -1, maxIdx = -1;
        char maxDigit = '0';

        for (int i = letters.length - 1; i >= 0; i--) {
            if (letters[i] > maxDigit) {
                maxDigit = letters[i];
                maxIdx = i;
            } else if (letters[i] < maxDigit) {
                l = i;
                r = maxIdx;
            }
        }

        char temp = letters[l];
        letters[l] = letters[r];
        letters[r] = temp;

        return new String(letters);
    }

}

