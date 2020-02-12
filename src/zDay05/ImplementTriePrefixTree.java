package zDay05;

/**
 * @program: LeetForWork
 * @description: 208. Implement Trie (Prefix Tree)
 * @author: Zekun Zhang
 * @create: 2020-02-10 18:05
 */

public class ImplementTriePrefixTree {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    private TrieNode root;
    /** Initialize your data structure here. */
    public ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return find(word, root, 0);
    }

    private boolean find(String word, TrieNode node, int index) {
        if (index == word.length()) return node.isWord;
        int i = word.charAt(index) - 'a';
        return node.children[i] != null && find(word, node.children[i], index + 1);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        // TrieNode node = root;
        // for (char c : prefix.toCharArray()) {
        //     if (node.children[c - 'a'] == null) return false;
        //     node = node.children[c - 'a'];
        // }
        // return true;
        return findPrefix(prefix, root, 0);
    }

    private boolean findPrefix(String word, TrieNode node, int index) {
        if (index == word.length()) return true;
        int i = word.charAt(index) - 'a';
        return node.children[i] != null && findPrefix(word, node.children[i], index + 1);
    }
}
