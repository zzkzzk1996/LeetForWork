package zDay11;

/**
 * @program: LeetForWork
 * @description: 79. Word Search
 * @author: Zekun Zhang
 * @create: 2020-02-22 18:37
 */

public class WordSearch {
    private boolean[][] visited;
    private int m, n;
    private boolean check;
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
        m = board.length;
        n = board[0].length;
        check = false;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    helper(board, word, i, j, 0);
                    if (check) return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private void helper(char[][] board, String word, int i, int j, int index) {
        if (index == word.length() - 1) {
            check = true;
            return;
        }
        if (i != m - 1 && !visited[i + 1][j]) {
            if (board[i + 1][j] == word.charAt(index + 1)) {
                visited[i + 1][j] = true;
                helper(board, word, i + 1, j, index + 1);
                if (check) return;
                visited[i + 1][j] = false;
            }
        }
        if (i != 0 && !visited[i - 1][j]) {
            if (board[i - 1][j] == word.charAt(index + 1)) {
                visited[i - 1][j] = true;
                helper(board, word, i - 1, j, index + 1);
                if (check) return;
                visited[i - 1][j] = false;
            }
        }
        if (j != n - 1 && !visited[i][j + 1]) {
            if (board[i][j + 1] == word.charAt(index + 1)) {
                visited[i][j + 1] = true;
                helper(board, word, i, j + 1, index + 1);
                if (check) return;
                visited[i][j + 1] = false;
            }
        }
        if (j != 0 && !visited[i][j - 1]) {
            if (board[i][j - 1] == word.charAt(index + 1)) {
                visited[i][j - 1] = true;
                helper(board, word, i, j - 1, index + 1);
                if (check) return;
                visited[i][j - 1] = false;
            }
        }
    }
}
