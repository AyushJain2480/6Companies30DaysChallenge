class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0,grid[0][0]));
        boolean[][] vis = new boolean[n][n];
        
        // moving in 4 directions for exploring !!
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        
        while(pq.size() > 0){
            Pair rem = pq.remove();
            // if you reach the last index return max so far!!
            if(rem.row == n - 1 && rem.col == n - 1){
                return rem.msf;
            }
            // If it is already visited don't explore further!!
            if(vis[rem.row][rem.col] == true) continue;
            
            // Now If we don't reach our destination and it is not visited than mark it as visited !!
            vis[rem.row][rem.col] = true;
            
            // Now Explore in all the 4 directions;
            for(int i = 0; i < 4; i++){
                int Row = rem.row + dir[i][0];
                int Col = rem.col + dir[i][1];
                // don't cross ur limits ok ^ ^
                if(Row < 0 || Col < 0 || Row >= n || Col >= n || vis[Row][Col] == true) continue;
                // if Row,Col is valid add it into the PQ
                pq.add(new Pair(Row, Col, Math.max(rem.msf , grid[Row][Col])));   
            } 
        }
        return 0;
    }
    public class Pair implements Comparable<Pair>{
        int row, col, msf;
        Pair(int row, int col , int msf){
            this.row = row; this.col = col; this.msf = msf;
        }
        @Override
        public int compareTo(Pair o){
            return this.msf - o.msf;
        }
    }
}
// The time complexity of this algorithm is O(n^2 * log(n^2)), where n is the size of the grid. This is because each cell in the grid can
// be added to the priority queue once, and for each cell, it takes O(log(n^2)) time to add to the priority queue, and O(1) time to remove 
// the minimum element. So, the total time complexity would be O(n^2 * log(n^2)).
