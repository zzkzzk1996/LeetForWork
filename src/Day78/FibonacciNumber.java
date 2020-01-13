package Day78;

/**
 * @program: LeetForWork
 * @description: 509. Fibonacci Number
 * @author: Zekun Zhang
 * @create: 2020-01-13 15:53
 */

public class FibonacciNumber {
    public int fib(int N) {
        if (N <= 1) return N;
        return fib(N - 1) + fib(N - 2);
    }

    int[] memo = new int[100000];
    public int fib1(int N) {
        if (N <= 1) return N;
        if (memo[N] == 0) {
            memo[N] = fib1(N - 1) + fib1(N - 2);
        }
        return memo[N];
    }

    //DP
    public int fibDP(int N) {
        if (N <= 1) return N;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    public int fibDPImpro(int N) {
        if (N <= 1) return N;
        int a = 0, b = 1;
        for (int i = 2; i <= N; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }
}
