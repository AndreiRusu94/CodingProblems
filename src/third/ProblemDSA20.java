package third;
/*
Given a string s, break s such that every substring of the partition can be found in the dictionary. Return the minimum break needed.

Examples:

Given a dictionary ["Cat", "Mat", "Ca",
     "tM", "at", "C", "Dog", "og", "Do"]
Input :  Pattern "CatMat"
Output : 1
Explanation: we can break the sentences
in three ways, as follows:
CatMat = [ Cat Mat ]  break 1
CatMat = [ Ca tM at ] break 2
CatMat = [ C at Mat ] break 2  so the
         output is: 1

Input : Dogcat
Output : 1
*/

public class ProblemDSA20 {
    public static void main(String[] args) {
        SolutionDSA20 solution = new SolutionDSA20();
        String[] keys = {"cat", "mat", "ca", "ma",
                "at", "c", "dog", "og", "do"};

        for (String key : keys) {
            solution.insert(key);
        }

        solution.minWordBreak("catmat");
        System.out.println(solution.minWordBreak);
    }
}

class SolutionDSA20 {
    TrieNode root = new TrieNode();
    int minWordBreak = Integer.MAX_VALUE;

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    public void insert(String key) {
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }

    public void minWordBreak(String key) {
        minBreakWordUtil(key, root, Integer.MAX_VALUE, 0, 0);
    }

    private void minBreakWordUtil(String key, TrieNode node, int currMinBreakWord, int start, int level) {
        TrieNode currNode = node;

        if (start == key.length()) {
            currMinBreakWord = Math.min(currMinBreakWord, level - 1);
            minWordBreak = Math.min(currMinBreakWord, minWordBreak);
            return;
        }

        for (int i = start; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currNode.children[index] == null) {
                return;
            }

            if (currNode.children[index].isEnd) {
                minBreakWordUtil(key, root, currMinBreakWord, i + 1, level + 1);
            }

            currNode = currNode.children[index];
        }
    }

}
