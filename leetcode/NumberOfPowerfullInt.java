// Not my code but a solution to the problem

class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long suff = 0L;

        for (char c : s.toCharArray()){
            suff = suff * 10 + c - '0';
        }

        if (suff > finish) return 0;

        long div = (long) Math.pow(10, s.length());
        long ps = start / div;
        long pf = finish / div;

        if (finish % div >= suff) pf++;
        if (start % div > suff) ps++;

        return getAvailNum(pf, limit) - getAvailNum(ps, limit);
    }

    private long getAvailNum(long num, long limit){
        if (num == 0) return 0;
        if (limit == 9) return num;

        int digits = (int) Math.log10(num);
        long div = (long) Math.pow(10, digits);
        long res = 0L;

        for (int i = digits; i >= 0; i--){
            int d = (int) (num / div);

            if (d > limit){
                return res + (long) Math.pow(limit + 1, i + 1);
            } else {
                res += d * (long) Math.pow(limit + 1, i);
            }

            num %= div;
            div /= 10;
        }

        return res;
    }
}