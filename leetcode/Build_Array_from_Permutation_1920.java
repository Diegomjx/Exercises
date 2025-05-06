class Solution {
    public int[] buildArray(int[] nums) {
        if (nums == null) return new int[0];

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }
}