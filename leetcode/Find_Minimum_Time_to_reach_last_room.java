class Solution {

    private int[][] moveTime;
    private int[][] memo;
    private int n,m;


    public int minTimeToReach(int[][] moveTime) {
        this.n = moveTime.length;
        this.m = moveTime[1].length;
        this.moveTime = moveTime;
        this.memo = new int[n][m];

        for(int[] row: memo)
                java.util.Arrays.fill(row, Integer.MAX_VALUE);

    /*
        int x=0,y=0,t=0;



  
        while( x != n-1 || y != m-1){

            if (y == m-1){
                x++;

                if (t < moveTime[x][y]){
                    t = moveTime[x][y];
                } 
                t++;
                
                continue;
            }

            if (x == n-1){
                y++;

                if (t < moveTime[x][y]){
                    t = moveTime[x][y];
                } 
                t++;
                
                continue;
            }



            if( moveTime[x+1][y] > moveTime[x][y+1]    ){
                y++;
                if (t < moveTime[x][y]){
                    t = moveTime[x][y];
                } 
                t++;

                
            }
            else {
                x++;
                if (t < moveTime[x][y]){
                    t = moveTime[x][y];
                } 
                t++;

                
            }

        }

        return t;
  */
        

        return recursionans (0, 0, 0);

        
    }


    private int recursionans (int x, int y, int t){



        if (x == n - 1 && y == m - 1)
            return Math.max(t  , moveTime[x][y]) + 1 ;
            

        if (t >= memo[x][y]) return Integer.MAX_VALUE;
        memo[x][y] = t;


        int curTime  = 0;
        if(x == 0 && y == 0){
             curTime = t;
        } else
        if ( t <= moveTime[x][y]    )
                curTime  = moveTime[x][y]+1;
            else
                curTime =  t+1;

       // int curTime = Math.max(t, moveTime[x][y]) + 1;
        int minTime = Integer.MAX_VALUE;

        if (x + 1 < n)
            minTime = Math.min(minTime, recursionans(x + 1, y, curTime));
        if (y + 1 < m)
            minTime = Math.min(minTime, recursionans(x, y + 1, curTime));
        if (y - 1 >= 0)
            minTime = Math.min(minTime, recursionans(x, y - 1, curTime));
        if (x - 1 >= 0)     
            minTime = Math.min(minTime, recursionans(x - 1, y, curTime)); 

        return minTime;
        

    }





}