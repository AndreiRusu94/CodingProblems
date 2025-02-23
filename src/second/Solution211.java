package second;
/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
*/


class Solution211 {
    public static void main(String[] args) {
        Solution211 sol = new Solution211();
        Trie obj = sol.new Trie();
        obj.addWord("test");
        System.out.println(obj.search("test"));
        System.out.println(obj.search("te."));
        System.out.println(obj.search("te.."));
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                var index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            return backtrack(word.toCharArray(), 0, root);
        }

        private boolean backtrack(char[] chars, int k, TrieNode node) {
            if (k == chars.length) {
                return node.isWord;
            }

            if (chars[k] == '.') {
                for (int i = 0; i < node.children.length; i++) {
                    if (node.children[i] != null && backtrack(chars, k + 1, node.children[i])) {
                        return true;
                    }
                }
            } else {
                return node.children[chars[k] - 'a'] != null && backtrack(chars, k + 1, node.children[chars[k] - 'a']);
            }

            return false;
        }
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
}
