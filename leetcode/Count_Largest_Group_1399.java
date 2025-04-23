class Solution {
    public int countLargestGroup(int n) {
        if ( n < 10) return n;

        int groups = 1;
        int sum = 0;
        int[] arr = new int[36];

        for ( int i = 1; i <= n ; i++){
            arr[num_digit(i)-1]++;
            
        }

        for ( int i = 0; i < arr.length; i++ ){
            if ( arr[i] == sum){
                groups++;
            }else if ( arr[i] > sum ){
                groups = 1;
                sum = arr[i];
            }
        }
        
        return groups;
        
    }

    int num_digit( int n){
           int sum = 0;
           String num = Integer.toString(n);

           for ( char c : num.toCharArray()){
            sum =sum+ c - '0';

           }

           return sum;
            
        }
}

