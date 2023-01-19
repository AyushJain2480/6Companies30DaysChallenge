class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][] curr = new double[n][n];
        double[][] next = new double[n][n];
        int[][] N = {{-2,+1},{-1,+2},{+1,+2},{+2,+1},{+2,-1},{+1,-2},{-1,-2},{-2,-1}};
      
        // initially
        curr[row][column] = 1;
        
        // starting from 1st move to k number of moves
        for(int move = 1; move <= k ; move++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(curr[i][j] != 0){
                        for(int l = 0; l < N.length; l++){
                             int ni = i + N[l][0];
                             int nj = j + N[l][1];
                              if(ni >= 0 && ni < n && nj >= 0 && nj < n){
                                next[ni][nj] += curr[i][j]/8.0;
                              }
                        }
                    }
                }
            }
            curr = next;
            next = new double[n][n];
        }
        double sum = 0.0;
        for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
              sum += curr[i][j];
          }
        }
        return sum;   
    }
}
