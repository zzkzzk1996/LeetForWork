package zDay05;

/**
 * @program: LeetForWork
 * @description: 211. Add and Search Word - Data structure design
 * @author: Zekun Zhang
 * @create: 2020-02-10 17:31
 */

public class AddandSearchWordDatastructuredesign {

    class TrieNode {
        TrieNode[] child;
        boolean isWord;

        public TrieNode() {
            child = new TrieNode[26];
            isWord = false;
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public AddandSearchWordDatastructuredesign() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word, root, 0);
    }

    private boolean find(String cur, TrieNode node, int index) {
        if (index == cur.length()) return node.isWord;
        if (cur.charAt(index) == '.') {
            for (TrieNode c : node.child) {
                if (c != null && find(cur, c, index + 1)) return true;
            }
            return false;
        } else {
            return node.child[cur.charAt(index) - 'a'] != null && find(cur, node.child[cur.charAt(index) - 'a'], index + 1);
        }
    }
}
