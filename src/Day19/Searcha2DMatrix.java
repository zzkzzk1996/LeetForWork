package Day19;

/**
 * @program: LeetForWork
 * @description: 74. Search a 2D Matrix
 * @author: Zekun Zhang
 * @create: 2019-09-20 00:21
 */

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = row * col - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (matrix[mid / col][mid % col] == target) return true;
            else if (matrix[mid / col][mid % col] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
