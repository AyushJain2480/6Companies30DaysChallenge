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
