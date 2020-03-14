package zDay21;

/**
 * @program: LeetForWork
 * @description: 79. Word Search
 * @author: Zekun Zhang
 * @create: 2020-03-13 17:41
 */

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (word.charAt(index++) == board[i][j]) {
            char c = board[i][j];
            board[i][j] = '#';

            boolean check = helper(board, word, i + 1, j, index) || helper(board, word, i - 1, j, index) || helper(board, word, i, j + 1, index) || helper(board, word, i, j - 1, index);
            board[i][j] = c;
            return check;
        }
        return false;
    }
}
