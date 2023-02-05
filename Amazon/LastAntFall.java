class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
       // consider it as 2 way roads
       // left ants are moving on one road and right ants are moving on other road
        
       // Input: n = 4, left = [4,3], right = [0,1]
       
       // 0 1 2 3 4   1st road
       // <---- a b
       // a will reach at the left end at t = 3s
       // b _____________________________ t = 4s

       // 0 1 2 3 4   2nd road
       // c d ---->
       // d will reach at the right end at t = (4 - 1) = 3s
       // c ______________________________ t = (4 - 0) = 4s

       // 4s is max time 

       int maxInLeft = 0;
       for(int num : left){
           maxInLeft = Math.max(maxInLeft , num);
       }
       int minInRight = Integer.MAX_VALUE;
       for(int num : right){
           minInRight = Math.min(minInRight, num);
       } 
       return Math.max(maxInLeft , n - minInRight); 
    }
}

       
   
