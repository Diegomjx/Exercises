// ysllc solution for leetcode problem 3341
// https://leetcode.com/problems/find-minimum-time-to-reach-last-room/description/


class Solution {
    // Directions array representing 4 possible movements: right, left, down, and up
    public static final int[][] DIR = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    // Method to find the minimum time to reach the bottom-right corner from the top-left corner
    public int minTimeToReach(int[][] moveTime) {
        // Get the number of rows (n) and columns (m) in the grid
        int n = moveTime.length, m = moveTime[0].length;
        
        // Create a 2D array to keep track of visited cells (initialize all to false)
        boolean[][] visited = new boolean[n][m];
        
        // Priority queue to store cells to be processed, ordered by the time to reach that cell
        // Each element in the queue is an array of size 3: [row, column, time]
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((r1, r2) -> r1[2] - r2[2]);
        
        // Add the starting point (top-left corner) to the priority queue with a time of 0
        pq.offer(new int[]{0, 0, 0});
        
        // Mark the starting point as visited
        visited[0][0] = true;
        
        // While the priority queue is not empty, continue processing cells
        while (!pq.isEmpty()) {
            // Poll the cell with the smallest time (i.e., the cell to be processed next)
            int[] cur = pq.poll();
            
            // Check if the current cell is the bottom-right corner (destination)
            if (cur[0] == n - 1 && cur[1] == m - 1) {
                // If we reached the destination, return the time it took to reach it
                return cur[2];
            }
            
            // Explore all 4 possible directions (right, left, down, up)
            for (int[] d : DIR) {
                // Calculate the new row and column based on the current direction
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];
                
                // Check if the new position is within bounds and not yet visited
                if (r >= 0 && r < n && c >= 0 && c < m && !visited[r][c]) {
                    // Mark the new position as visited
                    visited[r][c] = true;
                    
                    // Add the new position to the priority queue with the updated time
                    // The time to reach the new cell is the maximum of:
                    // 1. The time to reach the current cell + 1 (moving to the next cell)
                    // 2. The time to move through the new cell (moveTime[r][c] + 1)
                    pq.offer(new int[]{r, c, Math.max(cur[2] + 1, moveTime[r][c] + 1)});
                }
            }
        }
        
        // If the priority queue is empty and we haven't reached the destination, return -1 (impossible)
        return -1;
    }
}
