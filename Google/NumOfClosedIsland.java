// The catch here is that if the island of 0's is connected to a boundary 0. i.e i =0 || j=0 || i=length-1 || j=length-1 that island will not be considered since that would mean that this island is not completely surrounded by water i.e 1's on all sides.

class Solution {
    boolean flag = true;
    public int closedIsland(int[][] grid) {
        int closedIslandCount = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0){
                    
                    dfs(grid , i , j);
                        
                    // agar flag true he matlab boundary par land nhi he to inc krdo
                    if(flag)
                    closedIslandCount++;
                        
                    // for next round
                    flag = true;

                }
            }
        }
        return closedIslandCount;
    }

    
    public void dfs(int[][] grid , int i , int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length|| grid[i][j] == 1){
            return;
        }
        // agar boundary par land ho yani 0 to vo consider nhi karna he 
        // boundary par pani hona chahiye yani 1 tbhi island charo tarf se bhiga hoga 
        if((i == 0 | j == 0 || i == grid.length - 1 || j == grid[0].length - 1) && grid[i][j] == 0) flag = false;
        grid[i][j] = 1;
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j - 1); // left
        dfs(grid, i , j + 1); // right
    }
}


// This code is a solution for counting the number of connected islands in a 2D grid represented by a char array.
// It uses a nested loop to iterate through the grid, and whenever it encounters a land ('1') it increments the count and uses a
// recursive function called "exploringLand" to explore the adjacent lands and mark them as visited ('0') so that they are not counted
// again. The function checks if it has reached the boundary of the grid or a water ('0') and returns if it has. Finally, the function 
// returns the total count of islands.

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){ 
                    count++;
                    exploringLand(grid , i , j);
                }
            }
        }
        return count;
    }
    
    public void exploringLand(char[][] grid , int i , int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0'; 
        exploringLand(grid, i + 1, j); // down
        exploringLand(grid, i - 1, j); // up
        exploringLand(grid, i, j - 1); // left
        exploringLand(grid, i , j + 1); // right
    }
}
