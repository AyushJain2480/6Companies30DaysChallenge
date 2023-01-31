class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        
     int[][] res = new int[mat.length][mat[0].length];
     
     for(int i = 0; i < mat.length; i++){
         for(int j = 0; j < mat[0].length; j++){
             res[i][j] = sum(i,j,k, mat);
         }
     }
    return res;
    }
    
    public int sum(int i , int j , int k , int[][] mat){
    int sum = 0;
    int startRow = i - k;    
    if(startRow < 0){
        startRow = 0;
    }    
    int startCol = j - k;    
    if(startCol < 0){
        startCol = 0;
    }    
    int endRow = i + k;
    if(endRow >= mat.length){
        endRow = mat.length - 1;
    }
    int endCol = j + k;
    if(endCol >= mat[0].length){
        endCol = mat[0].length - 1;
    }
    for(int r = startRow; r <= endRow; r++){
        for(int c = startCol; c <= endCol; c++){
            sum += mat[r][c];
        }
    }
    return sum;    
    }
}
