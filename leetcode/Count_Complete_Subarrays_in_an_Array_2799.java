// File: Solution.java

import java.util.*;

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;

        // Step 1: Get total distinct elements
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : nums) uniqueSet.add(num);
        int totalDistinct = uniqueSet.size();

        int left = 0, result = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < n; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            while (freqMap.size() == totalDistinct) {
                result += n - right;
                int leftVal = nums[left];
                freqMap.put(leftVal, freqMap.get(leftVal) - 1);
                if (freqMap.get(leftVal) == 0) {
                    freqMap.remove(leftVal);
                }
                left++;
            }
        }

        return result;
    }
}
