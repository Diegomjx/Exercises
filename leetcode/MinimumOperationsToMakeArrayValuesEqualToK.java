// [5,2,5,4,5]   5->4   k=2
// [4,2,4,4,4]   4->2
// [2,2,2,2,2]   h=2


class Solution {
    public int minOperations(int[] nums, int k) {
        boolean[] seen = new boolean[101]; 
        int uniqueCount = 0;

        for (int num : nums) {
            if (num < k) return -1;  
            if (num != k && !seen[num]) {
                seen[num] = true;
                uniqueCount++;
            }
        }

        return uniqueCount;
    }
}