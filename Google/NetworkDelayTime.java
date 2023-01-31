class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int[][] dis = new int[n + 1][n + 1];
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                dis[i][j] = 10000;
            }
        }
        
        for(int i = 1; i <= n; i++){
            dis[i][i] = 0;
        }
        
        for(int[] t : times){
            dis[t[0]][t[1]] = t[2];
        }
        
        for(int l = 1; l <= n; l++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    dis[i][j] = Math.min(dis[i][j] , dis[i][l] + dis[l][j]);
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int j = 1; j <= n; j++){
            max = Math.max(dis[k][j] , max);
        }
        return max == 10000 ? -1 : max;
    }
}
