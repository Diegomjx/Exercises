class Solution {
    public int countLargestGroup(int n) {
        int[] count = new int[37]; 
        int maxSize = 0;
        int groups = 0;

        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            count[sum]++;
            if (count[sum] > maxSize) {
                maxSize = count[sum];
                groups = 1;
            } else if (count[sum] == maxSize) {
                groups++;
            }
        }

        return groups;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
