/*
Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.


  Example 1:
    Input:
    words = ["This", "is", "an", "example", "of", "text", "justification."]
    maxWidth = 16
    Output:
    [
       "This    is    an",
       "example  of text",
       "justification.  "
    ]
 */

import java.util.ArrayList;
import java.util.List;

public class Problem68 {
    public static void main(String[] args) {
        Solution68 solution = new Solution68();

        String[] input = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(solution.fullJustify(input, 16));
    }
}

class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> output = new ArrayList<>();
        List<String> currentRow = new ArrayList<>();
        int currentRowLength = -1;
        int count = 0;

        for (String word : words) {
            count++;
            if (count == words.length) {
                if (currentRowLength + 1 + word.length() > maxWidth) {
                    output.add(justifyRow(currentRow, currentRowLength, maxWidth));

                    StringBuilder sb = new StringBuilder(word);

                    while (sb.length() < maxWidth) {
                        sb.append(" ");
                    }

                    output.add(sb.toString());

                    return output;
                } else {
                    currentRow.add(word);
                    output.add(justifyLastRow(currentRow, maxWidth));
                    return output;
                }
            } else {
                if (currentRowLength + 1 + word.length() > maxWidth) {
                    output.add(justifyRow(currentRow, currentRowLength, maxWidth));
                    currentRow = new ArrayList<>();
                    currentRow.add(word);
                    currentRowLength = word.length();
                } else {
                    currentRowLength = currentRowLength + 1 + word.length();
                    currentRow.add(word);
                }
            }
        }

        return output;
    }

    public String justifyRow(List<String> currentRow, int currentRowLength, int maxWidth) {
        int availableEmptySpaces = maxWidth - currentRowLength;
        int equalSpaces, unevenSpaces;
        StringBuilder output = new StringBuilder();

        if (currentRow.size() == 1) {
            equalSpaces = availableEmptySpaces - 1;

            output.append(currentRow.get(0));
            for (int j = 0; j <= equalSpaces; j++) {
                output.append(" ");
            }

            return output.toString();
        } else {
            equalSpaces = availableEmptySpaces / (currentRow.size() - 1);
            unevenSpaces = availableEmptySpaces % (currentRow.size() - 1);
        }

        for (int index = 0; index < currentRow.size() - 1; index++) {
            output.append(currentRow.get(index));

            for (int j = 0; j <= equalSpaces; j++) {
                output.append(" ");
            }

            if (unevenSpaces > 0) {
                output.append(" ");
                unevenSpaces--;
            }
        }


        output.append(currentRow.get(currentRow.size() - 1));

        return output.toString();
    }

    public String justifyLastRow(List<String> currentRow, int maxWidth) {
        StringBuilder output = new StringBuilder(String.join(" ", currentRow));

        while (output.length() < maxWidth) {
            output.append(" ");
        }

        return output.toString();
    }
}