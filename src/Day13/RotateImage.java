package Day13;

/**
 * @program: LeetForWork
 * @description: 48. Rotate Image
 * @author: Zekun Zhang
 * @create: 2019-09-13 20:55
 */

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (matrix == null || n == 0) return;
        horizontal(matrix);
        counterDiagonal(matrix);
    }
    private void horizontal(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    private void counterDiagonal(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }
    }
}
