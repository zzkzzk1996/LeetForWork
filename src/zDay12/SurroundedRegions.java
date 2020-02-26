package zDay12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetForWork
 * @description: 130. Surrounded Regions
 * @author: Zekun Zhang
 * @create: 2020-02-25 18:03
 */

public class SurroundedRegions {
    /**
     * DFS
     * @param args
     */
//    public static void solve(char[][] board) {
//        if (board == null || board.length == 0) return;
//        for (int i = 0; i < board.length; i++) {
//            if (board[i][0] == 'O') {
//                helper(board, i, 0);
//            }
//            if (board[i][board[0].length - 1] == 'O') {
//                helper(board, i, board[0].length - 1);
//            }
//        }
//
//        for (int i = 0; i < board[0].length; i++) {
//            if (board[0][i] == 'O') {
//                helper(board, 0, i);
//            }
//            if (board[board.length - 1][i] == 'O') {
//                helper(board, board.length - 1, i);
//            }
//        }
//
//        for (char[] c : board) {
//            System.out.println(Arrays.toString(c));
//        }
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (board[i][j] == 'O') {
//                    board[i][j] = 'X';
//                }
//                if (board[i][j] == 'V') {
//                    board[i][j] = 'O';
//                }
//            }
//        }
//        for (char[] c : board) {
//            System.out.println(Arrays.toString(c));
//        }
//    }
//
//    private static void helper(char[][] board, int i, int j) {
//        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != 'O') return;
//        board[i][j] = 'V';
//        helper(board, i + 1, j);
//        helper(board, i - 1, j);
//        helper(board, i, j + 1);
//        helper(board, i, j - 1);
//    }

    public static void main(String[] args) {
        char[][] board = new char[][] {{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','O','O','O','O'},{'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},{'X','O','O','X','O','X','O','O','O','O','X','O','O','X','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','X','O'},{'O','X','X','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','X','O','O','O','O','O','O','X','O','O','O','O','O','X','X','O'},{'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'},{'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},{'X','O','O','O','O','O','O','O','O','X','X','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O'},{'O','O','O','O','X','O','O','O','O','O','O','O','O','X','O','O','O','O','O','X'},{'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','X','O','X','O','O'},{'O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','X','X','O','O','O','X','O','O','X','O','O','X'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'}};
//        for (char[] c : board) {
//            System.out.println(Arrays.toString(c));
//        }
        System.out.println();
        solve(board);
    }

    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                helper(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                helper(board, i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                helper(board, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                helper(board, board.length - 1, i);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void helper(char[][] board, int I, int J) {

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        queue.offer(new Pair<>(I, J));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> cur = queue.poll();
            int i = cur.getKey(), j = cur.getValue();
            if (board[i][j] != 'O') continue;
            board[i][j] = 'V';
            if (i > 0 && board[i - 1][j] == 'O') {
                queue.offer(new Pair<>(i - 1, j));
            }
            if (i < board.length - 1 && board[i + 1][j] == 'O') {
                queue.offer(new Pair<>(i + 1, j));
            }
            if (j < board[0].length - 1 && board[i][j + 1] == 'O') {
                queue.offer(new Pair<>(i, j + 1));
            }
            if (j > 0 && board[i][j - 1] == 'O') {
                queue.offer(new Pair<>(i, j - 1));
            }
        }
    }

    static class Pair <K, V> {

        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }
    }
}
