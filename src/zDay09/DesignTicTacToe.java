package zDay09;

/**
 * @program: LeetForWork
 * @description: 348. Design Tic-Tac-Toe
 * @author: Zekun Zhang
 * @create: 2020-02-16 17:04
 */

public class DesignTicTacToe {

    private int[] row;
    private int[] col;
    private int diagonal;
    private int antidiagonal;
    private int n;
    /** Initialize your data structure here. */
    public DesignTicTacToe(int n) {
        this.row = new int[n];
        this.col = new int[n];
        this.diagonal = 0;
        this.antidiagonal = 0;
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add = player == 1 ? -1 : 1;
        this.row[row] += add;
        this.col[col] += add;
        if (row == col) diagonal += add;
        if (col == this.col.length - row - 1) antidiagonal += add;
        if (Math.abs(this.row[row]) == n || Math.abs(this.col[col]) == n || Math.abs(diagonal) == n || Math.abs(antidiagonal) == n) return player;
        return 0;
    }
}
