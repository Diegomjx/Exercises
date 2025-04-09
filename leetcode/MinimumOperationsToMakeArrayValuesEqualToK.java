
// [5,2,5,4,5]   5->4   k=2
// [4,2,4,4,4]   4->2
// [2,2,2,2,2]   h=2

import java.util.HashSet;

class Solution {
    public int minOperations(int[] nums, int k){
        HashSet<Integer> uniqueValues = new HashSet<>();
        for (int i=0; i < nums.length ; i++){
            if (nums[i] < k )
                return -1;
            if(nums[i] != k)
                uniqueValues.add(nums[i]);
        }

        return uniqueValues.size();

    }
}