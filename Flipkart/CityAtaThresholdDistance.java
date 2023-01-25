// Iterate all point middle point k,
// iterate all pairs (i,j).
// If it go through the middle point k,
// dis[i][j] = dis[i][k] + dis[k][j].


// Complexity
// Time O(N^3)
// Space O(N^2)

class Solution{
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int smallest = n; 
        int result = 0;
        int dis[][] = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dis[i][j] = 10001;
            }
        }    
        
        for(int i = 0; i < n; i++){
            dis[i][i] = 0;
        }
        
        for(int[] e : edges){
            dis[e[0]][e[1]] = dis[e[1]][e[0]] = e[2];
        }
        
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    dis[i][j] = Math.min(dis[i][j] , dis[i][k] + dis[k][j]);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(dis[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= smallest){
                result = i;
                smallest = count;
            }
        }
        return result;
    }
}
