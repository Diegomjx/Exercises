class Solution {

    public int numTilings(int n) {
         return (int)DominoV3(n);



        
    }

    private long FibonachiDomino ( long n){
        if (n == 1 || n == 0 ) return 1;
        if (n  < 0 ) return 0;
             
         return 2*FibonachiDomino(n-1) + FibonachiDomino(n-3);
    }

    private long Domonio( int n){
        int M = 1000000007;
        long[] fib = new long[n+1];
        fib[0] = 1;
        fib[1] = 1;
        fib[2] = 2;

        for(int i = 3; i < n+1; i++){
            if (i == 1 || i == 0 ) 
                fib[i] = 1;
            else
                fib[i] = (2*fib[i-1] + fib [i-3])%M;
        }

        return fib[n];



    }



private long DominoV2(int n) {
    int M = 1000000007;

    if (n == 0 || n == 1) return 1;
    if (n == 2) return 2;

    long[] fib = new long[4];
    fib[0] = 1;
    fib[1] = 1;
    fib[2] = 2;

    for (int i = 3; i <= n; i++) {
        int idx = i % 4;
        fib[idx] = (2 * fib[(i - 1) % 4] + fib[(i - 3) % 4]) % M;
    }

    return fib[n % 4];
}


private long DominoV3(int n) {
    final int MOD = 1_000_000_007;

    if (n == 0 || n == 1) return 1;
    if (n == 2) return 2;

    long a = 1; // f(n-3)
    long b = 1; // f(n-2)
    long c = 2; // f(n-1)
    long next = 0;

    for (int i = 3; i <= n; i++) {
        next = (2 * c + a) % MOD;
        a = b;
        b = c;
        c = next;
    }

    return next;
}







}



