package zDay05;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetForWork
 * @description: 212. Word Search II
 * @author: Zekun Zhang
 * @create: 2020-02-11 16:04
 */

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    /* dfs functions */
    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char c = board[i][j];
        if (c == '#' || root.children[c - 'a'] == null) return;
        root = root.children[c - 'a'];
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';
        dfs(board, i + 1, j, root, res);
        dfs(board, i - 1, j, root, res);
        dfs(board, i, j + 1, root, res);
        dfs(board, i, j - 1, root, res);
        board[i][j] = c;
    }

    /* construct the Trie */
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
        return root;
    }

    /* define TrieNode */
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}
