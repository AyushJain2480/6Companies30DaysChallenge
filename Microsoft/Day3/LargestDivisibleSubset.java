/* 
 * Sort nums
 * Find size of longest divisible subset through the same approach as in LIS (Longest Increasing Subsequence)
 * Construct LDS by iterating through dp from right to left
 */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        return constructLDS(dp , nums , getLDSSize(nums , dp));
    }

    private int getLDSSize(int[] nums , int[] dp) {
      Arrays.sort(nums);  
      Arrays.fill(dp,1);

      int ldsSize = 1 ;
      for(int i = 1; i < nums.length; i++){
        for(int j = 0; j < i; j++){
           if(nums[i] % nums[j] == 0){
               dp[i] = Math.max(dp[i] , dp[j] + 1);
               ldsSize = Math.max(ldsSize , dp[i]);
           }
        }
      }
      return ldsSize;
    } 

    private List<Integer> constructLDS(int[] dp , int[] nums , int ldsSize){
        int prev = -1;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = dp.length - 1; i >= 0; i--){
            if(dp[i] == ldsSize && (prev == -1 || prev % nums[i] == 0)){
              list.addFirst(nums[i]);
              ldsSize--;
              prev = nums[i];
            }
        }
        return list;
    }
}
