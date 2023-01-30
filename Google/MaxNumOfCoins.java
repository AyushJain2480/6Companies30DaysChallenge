class Solution {
    public int maxCoins(int[] piles) {
       
         Arrays.sort(piles);
         int res = 0;
         int n = piles.length;
       
        // if n = 9 means 3 smallest(bob) , 3 largest(alice) , 3 medium(you)
        // after sorting the largest element will reach at the last and smallest at the beginning 
        // for array [9,8,7,6,5,1,2,3,4] after sorting --> [1,2,3,4,5,6,7,8,9]
        //  9 / 3 = 3 piles can be possible of length 3
        //  let say if we give the 3 smallest [1,2,3] to bob && 3 largest [7,8,9] to alice so you take [4,5,6]
        //  but in this case the total coins we have now is 6 + 4 + 5 = 15
        //  but we want maximum no of coins so we need to maximise the value of medium 
        //  see 3 smallest we give to bob no change here 
        //  [Small Small Small Medium Large Medium Large Medium Large ] In this way medium will be maximise
        
        for(int i = n - 2; i >= n / 3; i-=2){
             res += piles[i];
        }
        return res;
    }
}
