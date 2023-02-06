// Let's see some Similar problems on Islands 

// [1] Max Area of Island
class Solution {
    int area = 0;
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){ 
                    area = 0;
                    exploringLand(grid , i , j);
                    maxArea = Math.max(area , maxArea);
                }
            }
        }
        return maxArea; 
    }
    public void exploringLand(int[][] grid , int i , int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0){
            return;
        }
        area++;
        grid[i][j] = 0; 
        exploringLand(grid, i + 1, j); // down
        exploringLand(grid, i - 1, j); // up
        exploringLand(grid, i, j - 1); // left
        exploringLand(grid, i , j + 1); // right
    }
}


// [2] Q -200 Number of Islands
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


// [3] Number of Closed Islands
class Solution {
    boolean flag = true;
    public int closedIsland(int[][] grid) {
        int closedIslandCount = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0){
                    dfs(grid , i , j);
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
        if((i == 0 | j == 0 || i == grid.length - 1 || j == grid[0].length - 1) && grid[i][j] == 0) flag = false;
        grid[i][j] = 1;
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j - 1); // left
        dfs(grid, i , j + 1); // right
    }
}
