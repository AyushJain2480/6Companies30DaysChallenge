// Asked by google this is a question of N-ary Tree where childs are more than 2.
class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return solve(grid, 0, 0, n);
    }
    
    public Node solve(int[][] grid , int x , int y , int n){
        if(isAllSame(grid, x, y, n)){ // It is leaf node
             return new Node(grid[x][y] == 1 ? true : false, true);
        }
        else{ // not a leaf node construct 4 childs
            Node root = new Node(true , false);
            root.topLeft = solve(grid , x , y , n/2);
            root.topRight = solve(grid , x , y + n/2 , n/2);
            root.bottomLeft = solve(grid , x + n/2 , y , n/2);
            root.bottomRight = solve(grid , x + n/2 , y + n/2 , n/2);
            return root;
        }
    }
    
    public boolean isAllSame(int[][] grid, int x , int y , int n){
        // x = 0 , y = 0
        // x + n = n
        // y + n = n
        for(int i = x; i < x + n; i++){
            for(int j = y; j < y + n; j++){
                if(grid[i][j] != grid[x][y]){
                    return false;
                }
            }
        }
        return true;
    }
}
