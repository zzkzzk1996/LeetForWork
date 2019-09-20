package Day19;

/**
 * @program: LeetForWork
 * @description: 240. Search a 2D Matrix II
 * @author: Zekun Zhang
 * @create: 2019-09-20 00:22
 */

public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) return true;
            if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
