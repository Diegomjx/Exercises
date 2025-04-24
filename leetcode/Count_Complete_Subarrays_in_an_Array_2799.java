// 1. Find distinct elementes in the array
// 2. Count complete subarrays in an Array


class Solution {
    public int countCompleteSubarrays(int[] nums) {

        HashSet<Integer> k = new HashSet<Integer>();
        int num_repeat =0;
        int subarray = 0;

        for ( int unique: nums){
                k.add(unique);
        }

        num_repeat = k.size();

        if (num_repeat ==0){
            return 1;
        }

        

        for (int i = 0; i < nums.length; i++ ){
            int n = num_repeat;
            k.clear();

            for (int j=i; j < nums.length; j++){


                
                if ( !k.contains( nums[j]  )){
                     n--;
                     k.add(nums[j]);

                     }
                     
                if ( n == 0){
                    subarray += nums.length-j;
                    break;
                }

                    
            }   
        }

        
        return subarray;
        
    }
}