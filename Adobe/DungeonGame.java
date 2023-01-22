// Bottom Up approach 
class Solution {
    public int calculateMinimumHP(int[][] dungeon){
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        
        // dp table 
        int[][]dp = new int[rows][cols];
        for(int i = rows - 1; i >= 0; i--){
            for(int j = cols - 1; j >= 0; j--){
                if(i == rows - 1 && j == cols - 1)
                    dp[i][j] = Math.min(0 , dungeon[i][j]);
                
                else if(i == rows - 1)
                    dp[i][j] = Math.min(0 , dungeon[i][j] + dp[i][j + 1]);
                
                else if(j == cols - 1)
                    dp[i][j] = Math.min(0 , dungeon[i][j] + dp[i + 1][j]);
                
                else 
                    dp[i][j] = Math.min(0 , Math.max(dp[i][j + 1] , dp[i + 1][j]) + dungeon[i][j]);
            }
        }
        return Math.abs(dp[0][0]) + 1;
    }
}
