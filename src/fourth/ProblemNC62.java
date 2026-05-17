package fourth;
/*
Design a data structure that supports adding new words and searching for existing words.

Implement the WordDictionary class:

void addWord(word) Adds word to the data structure.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word
may contain dots '.' where dots can be matched with any letter.
Example 1:

Input:
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["day"],["bay"],["may"],["say"],["day"],[".ay"],["b.."]]

Output:
[null, null, null, null, false, true, true, true]

Explanation:
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("day");
wordDictionary.addWord("bay");
wordDictionary.addWord("may");
wordDictionary.search("say"); // return false
wordDictionary.search("day"); // return true
wordDictionary.search(".ay"); // return true
wordDictionary.search("b.."); // return true
Constraints:

1 <= word.length <= 20
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 2 dots in word for search queries.
At most 10,000 calls will be made to addWord and search.
*/

public class ProblemNC62 {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("day");
        wordDictionary.addWord("bay");
        wordDictionary.addWord("may");
        System.out.println(wordDictionary.search("say"));
        System.out.println(wordDictionary.search("day"));
        System.out.println(wordDictionary.search(".ay"));
        System.out.println(wordDictionary.search("b.."));
    }
}

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if (word == null) {
            return;
        }

        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode root) {
        TrieNode curr = root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : curr.children) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }

                return false;
            } else {
                if (curr.children[c - 'a'] == null) {
                    return false;
                }

                curr = curr.children[c - 'a'];
            }
        }
        return curr.isWord;
    }
}

class TrieNode {

    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

