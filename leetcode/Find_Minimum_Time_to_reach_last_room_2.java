class Solution {
    private static final int[][] DIR = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
 
 
 
    public int minTimeToReach(int[][] moveTime) {
        boolean par = false;
        int n=moveTime.length, m=moveTime[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((r1,r2)->r1[2]-r2[2]);
 
        pq.offer(new int[]{0,0,0});
        visited[0][0]=true;
 
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[0]==n-1 && cur[1]==m-1){
                return cur[2];
            }
            for(int[] d:DIR){
                int r=cur[0]+d[0];
                int c=cur[1]+d[1];
                if(r>=0 && r <n && c>=0 && c<m && !visited[r][c]){
                    visited[r][c]=true;
                    pq.offer(new int[]{r, c, Math.max(cur[2]+  (cur[0] + cur[1])%2 + 1, moveTime[r][c] +  (cur[0] + cur[1])%2+1)});
                }
            }
        }
        return -1;
    }
 }