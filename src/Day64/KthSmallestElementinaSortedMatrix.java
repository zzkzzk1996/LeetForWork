package Day64;

import java.util.PriorityQueue;

/**
 * @program: LeetForWork
 * @description: 378. Kth Smallest Element in a Sorted Matrix
 * @author: Zekun Zhang
 * @create: 2019-11-03 19:48
 */

public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                pq.offer(matrix[i][j]);
                if (pq.size() > k) pq.poll();
            }
        }
        return pq.poll();
    }

    public int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            int num = count(matrix, mid);
            if (num >= k) right = mid;
            else left = mid;
        }
        return (count(matrix, right) < k) ? right : left;
    }

    private int count(int[][] matrix, int target) {
        int n = matrix.length;
        int i = n - 1, j = 0, res = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] < target) {
                res += i + 1;
                j++;
            } else i--;
        }
        return res;
    }
}
