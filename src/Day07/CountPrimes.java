package Day07;

/**
 * @program: LeetForWork
 * @description: 204. Count Primes
 * @author: Zekun Zhang
 * @create: 2019-09-07 21:46
 */

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) res++;
            for (int j = 2; i * j < n; j++) {
                notPrime[i * j] = true;
            }
        }
        return res;
    }
}
