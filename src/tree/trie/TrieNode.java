package tree.trie;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-12-02 15:40
 */

public class TrieNode {

    TrieNode[] children;
//    HashMap<Character, TrieNode> map;
    boolean isWord;
//    String[] word;

    public TrieNode() {
        TrieNode[] children = new TrieNode[26];
        this.isWord = false;
    }
}
