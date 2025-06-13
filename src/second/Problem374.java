package second;

/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.

Example 1:

Input: n = 10, pick = 6
Output: 6
Example 2:

Input: n = 1, pick = 1
Output: 1
*/

public class Problem374 {

    public static void main(String[] args) {
        Solution374 solution = new Solution374();
        System.out.println(solution.guessNumber(10, 6));

    }
}

class Solution374 {
    public int guessNumber(int n, int pick) {
        int left = 1, right = n;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int isRightNumber = guess(middle, pick);
            if (isRightNumber == 0) {
                return middle;
            } else {
                if (isRightNumber == 1) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }

    private int guess(int guess, int pick) {
        if (guess == pick) {
            return 0;
        }

        if (guess < pick) {
            return 1;
        }

        return -1;
    }
}