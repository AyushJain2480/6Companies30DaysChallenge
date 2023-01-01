// First Calculate F(0) than update F(1) and F(2) with below equations and find max of all

// F(1) - F(0) = S - n * A[n - 1] ---> F(1) = F(0) + S - n * A[n - 1]
// F(2) - F(1) = S - n * A[n - 2] ---> F(2) = F(1) + S - n * A[n - 2]
// F(3) - F(2) = S - n * A[n - 3]

class Solution {
    public int maxRotateFunction(int[] nums) {
        int F = 0;
        int S = 0;
        for(int i = 0; i < nums.length; i++){
            F = F + (nums[i] * i);
            S = S + nums[i];
        }

        int max = F; // this is F0
        int n = nums.length;
        for(int i = n - 1; i >= 1 ; i--){
            F = F + S - n * nums[i];
            max = Math.max(max , F);
        }
      return max;
    }
}
