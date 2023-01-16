class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int left, right, top ,bottom;
        int curSum = 0;
        // priority queue that stores the smallest sum at the top
        Queue<Integer> pq = new PriorityQueue<>((a,b)->(a-b));
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                left = right = col;
                top = bottom = row;
                // stop when any side hits border
                while(left >= 0 && right <= n-1 && bottom <= m-1){
                    curSum = calSum(grid,left,right,top,bottom);
                    left--; right++; bottom+=2;
                    
                    // add the current sum to priority queue
                    if(!pq.contains(curSum)){
                        pq.add(curSum);
                    }
                    if(pq.size() > 3){
                        pq.remove();
                    }
                }
            }
        }

        int[] arr = new int[pq.size()];
        for(int i = arr.length - 1; i >= 0; i--){
            arr[i] = pq.remove();
        }
        return arr; // return three largest sum of rhombus
    }
  
  private int calSum(int[][] grid ,int left,int right, int top , int bottom){
  
  int sum = 0;
  int leftCol = (left + right)/2;
  int rightCol = (left + right)/2;
  boolean expand = true;
  int currRow = top;

  while(currRow <= bottom){ // when curent row reaches from top to bottom means our sum is calculated

       if(leftCol == rightCol){
           sum += grid[currRow][leftCol]; // if leftCol and rightCol is same means there is one grid , so add it to the sum 
       }else{
       sum += grid[currRow][leftCol] + grid[currRow][rightCol];// if not means there are 2 grids leftgrid and rightgrid add them to sum 
       }

       if(leftCol == left){
           expand = false;
       }
       if(expand == false){ // reaches left border start shrinking
            leftCol++;
            rightCol--;
       }else{  // if it not reaches left border start expanding 
            leftCol--;
            rightCol++;
       }
       currRow++;
  }
   return sum;
  }

}
