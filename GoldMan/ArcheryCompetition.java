class Solution {

    int maxScore = 0;
    int[] maxStore = null;

    // I m starting from index 0 
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        helper(numArrows , 0 , 0 , aliceArrows , new int[12]);
        return maxStore;
    }
    // These are base conditions 
    // If numArrows reduces to 0 that means we have used all the arrows 
    // and also when index i reaches to 12 means you have completed all the 12 rounds 
   
    // At Base condition 
    // check if score > maxScore if yes update maxScore and store this storeArray
    // into maxStore because we want to return this maxStore array.

    public void helper(int numArrows , int i , int score , int[] arr , int[] store){

         if (i == 12 || numArrows == 0) {
            if (score > maxScore) {
                maxScore = score; // storing the maxScore
                maxStore = store.clone(); // storing the maxStore array 
                maxStore[0] += numArrows;
            }
            return;
        }
      
        int val = arr[i];
        if(numArrows - (val + 1) >= 0){ 
            store[i] = val + 1; 
            helper(numArrows - (val + 1) , i + 1 , score + i , arr , store);
            store[i] = 0; 
        }
        helper(numArrows , i + 1 , score , arr , store);
    }
}

          
   
