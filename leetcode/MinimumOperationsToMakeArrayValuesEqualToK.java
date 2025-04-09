// [5,2,5,4,5]   5->4   k=2
// [4,2,4,4,4]   4->2
// [2,2,2,2,2]   h=2

import java.util.HashSet;

class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> uniqueValues = new HashSet<>();
        
        for (int num : nums) {
            if (num < k) return -1;  
            if (num != k) uniqueValues.add(num);
        }
        
        return uniqueValues.size();
    }
}