package Day13;

/**
 * @program: LeetForWork
 * @description: 59. Spiral Matrix II
 * @author: Zekun Zhang
 * @create: 2019-09-13 21:38
 */

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int temp = 1, rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                res[rowStart][i] = temp++;
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                res[i][colEnd] = temp++;
            }
            colEnd--;

            for (int i = colEnd; i >= colStart; i--) {
                res[rowEnd][i] = temp++;
            }
            rowEnd--;

            for (int i = rowEnd; i >= rowStart; i--) {
                res[i][colStart] = temp++;
            }
            colStart++;
        }
        return res;
    }
}
