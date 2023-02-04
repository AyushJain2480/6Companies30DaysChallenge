// This one is TLE
class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int findLength(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i; j < nums1.length; j++) {
                 int[] arr = Arrays.copyOfRange(nums1, i, j + 1);
                 map.put(Arrays.toString(arr), arr.length);
            }
        }
      
        int maxLength = 0;
        for(int i = 0; i < nums2.length; i++){
            for(int j = i; j < nums2.length; j++){
               int[] arr = Arrays.copyOfRange(nums2, i, j + 1);
               if(map.containsKey(Arrays.toString(arr))){
                   maxLength = Math.max(maxLength, arr.length);
               } 
            }
        }
        return maxLength;
    }
}
// 1. Brute Force (previously it is TLE but now its accepted with time complexity of 5ms)

// Loop through all the elements in A and B, and check the corresponding matchness
// If the elements match, we check as far as we can and then get the maximum length
// Else we skip
// Time complexity O(mn^2)
// Space complexity O(1)

class Solution {
    public int findLength(int[] A, int[] B) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    int k = 1;
                    while (i + k < A.length && j + k < B.length && A[i + k] == B[j + k]) k++;
                    res = Math.max(res, k);
                }
            }
        }
        return res;
    }
}

// optimised approach - similar to Longest Common substring 

My Leetcode post - https://leetcode.com/problems/maximum-length-of-repeated-subarray/discuss/3142380/java-similar-to-lcs-explained-with-diagram

// We directly start making a 2d dp array of dimensions (A.length+1)*(B.length+1).

// For each cell, we compare the corresponding prefix of A with the corresponding prefix of B and find their longest common suffix. The length of this longest common suffix will be stored in the cell.

// For the marked cell, the corresponding prefixes for the cell are [5,4,3] and [7,8,4,3]. The longest common suffix for these prefixes is [4,3] which is of length 2. Hence 2 is stored in the marked cell.

// If the end elements of the two prefixes are not the same [5,4,3] and [7,8,4] (i.e 3!= 4), we can directly say that the length of their common suffix is 0.

// Else if the end elements are the same as shown in figure , then we compare the last elements of the array before it. The answer for this problem is stored in the cell corresponding to the prefixes [5,4] and [7,8,4].
// Hence the final answer is 1 added to the length stored in the immediate northwest cell. dp[i][j] = dp[i - 1][j - 1] + 1;

// Our desired answer is the maximum value of length in the array which is 3.

class Solution{
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max , dp[i][j]);
            }
        }
        return max;
    }
}










