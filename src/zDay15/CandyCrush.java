package zDay15;

/**
 * @program: LeetForWork
 * @description: 723. Candy Crush
 * @author: Zekun Zhang
 * @create: 2020-03-02 13:19
 */

public class CandyCrush {
    public int[][] candyCrush(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return board;
        boolean change = false;
        int R = board.length, C = board[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C - 2; j++) {
                int v = Math.abs(board[i][j]);
                if (v != 0 && v == Math.abs(board[i][j + 1]) && v == Math.abs(board[i][j + 2])) {
                    change = true;
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -v;
                }
            }
        }

        for (int i = 0; i < R - 2; i++) {
            for (int j = 0; j < C; j++) {
                int v = Math.abs(board[i][j]);
                if (v != 0 && v == Math.abs(board[i + 1][j]) && v == Math.abs(board[i + 2][j])) {
                    change = true;
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -v;
                }
            }
        }

        for (int j = 0; j < C; j++) {
            int r = R - 1;
            for (int i = R - 1; i >= 0; i--) {
                if (board[i][j] > 0) board[r--][j] = board[i][j];
            }
            while (r >= 0) {
                board[r--][j] = 0;
            }
        }

        return change ? candyCrush(board) : board;
    }
}
