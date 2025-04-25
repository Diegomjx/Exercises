
class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
//using prefix sum
    Map<Integer, Long> freq = new HashMap<>();
    freq.put(0, 1L);

    long cnt = 0;
    long ans = 0;

    for (int num : nums) {
        if (num % modulo == k) {
            cnt++;
        }

        int modValue = (int)(cnt % modulo);
        int target = (modValue - k + modulo) % modulo;
        ans += freq.getOrDefault(target, 0L);
        freq.put(modValue, freq.getOrDefault(modValue, 0L) + 1);
    }

    return ans;

    }




    public static long planSlow(List<Integer> nums, int modulo, int k) {
        int cnt = 0;
        int ans = 0;

        for(int i = 0; i< nums.size() ; i++){

            cnt = 0;
            for(int j=i; j < nums.size(); j++){
                if ( nums.get(j) % modulo == k){
                     cnt++;
                }

                if ( cnt % modulo == k)
                    ans++;

            }
        }

        return ans;
        
    }
}