import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX = 10000;
    private long[] factorial;
    private long[] invFactorial;

    public int idealArrays(int n, int maxValue) {
        // Precompute factorials for combinations
        precomputeFactorials(n + 15); // Safe margin for combinations

        int limit = maxValue;
        long result = 0;

        for (int val = 1; val <= maxValue; val++) {
            // Get prime factors of val
            Map<Integer, Integer> primeCount = primeFactorize(val);

            long ways = 1;
            for (int exponent : primeCount.values()) {
                // Use stars and bars: (n-1 + exponent choose exponent)
                ways = (ways * comb(n - 1 + exponent, exponent)) % MOD;
            }

            result = (result + ways) % MOD;
        }

        return (int) result;
    }
    // Precomputes factorials and inverse factorials up to 'size' for fast binomial calculations
    private void precomputeFactorials(int size) {
        factorial = new long[size];
        invFactorial = new long[size];

        factorial[0] = 1;
        for (int i = 1; i < size; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        invFactorial[size - 1] = modInverse(factorial[size - 1]);
        for (int i = size - 2; i >= 0; i--) {
            invFactorial[i] = (invFactorial[i + 1] * (i + 1)) % MOD;
        }
    }
    // Returns n choose k using precomputed factorials
    private long comb(int n, int k) {
        if (k > n) return 0;
        return factorial[n] * invFactorial[k] % MOD * invFactorial[n - k] % MOD;
    }
    // Computes modular inverse using Fermat's Little Theorem
    private long modInverse(long x) {
        return pow(x, MOD - 2);
    }
    // Fast modular exponentiation: computes base^exp % MOD
    private long pow(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
    // Returns a map of prime factors and their counts for a given number
    private Map<Integer, Integer> primeFactorize(int num) {
        Map<Integer, Integer> factors = new HashMap<>();
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                num /= i;
            }
        }
        if (num > 1) factors.put(num, 1);
        return factors;
    }
}