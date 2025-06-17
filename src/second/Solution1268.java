package second;
/*
You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.

Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
After typing mou, mous and mouse the system suggests ["mouse","mousepad"].
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Explanation: The only word "havana" will always be suggested while typing the search word.

Constraints:

1 <= products.length <= 1000
1 <= products[i].length <= 3000
1 <= sum(products[i].length) <= 2 * 104
All the strings of products are unique.
products[i] consists of lowercase English letters.
1 <= searchWord.length <= 1000
searchWord consists of lowercase English letters.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution1268 {
    public static void main(String[] args) {
        Solution1268 sol = new Solution1268();
        System.out.println(sol.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String product : products) {
            insert(product, root);
        }

        return search(searchWord, root);
    }

    private void insert(String product, TrieNode root) {
        TrieNode node = root;

        for (char c : product.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.suggestion.offer(product);
            Collections.sort(node.suggestion);
            if (node.suggestion.size() > 3) {
                node.suggestion.pollLast();
            }
        }
    }

    private List<List<String>> search(String searchWord, TrieNode root) {
        List<List<String>> output = new ArrayList<>();

        for (char c : searchWord.toCharArray()) {
            if (root != null) {
                root = root.children[c - 'a'];
            }

            output.add(root == null ? List.of() : root.suggestion);
        }

        return output;
    }


    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        LinkedList<String> suggestion = new LinkedList<>();
    }
}
