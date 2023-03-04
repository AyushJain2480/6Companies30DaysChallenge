Intuition
The problem is to find the number of subarrays in an array that contain both the maximum and minimum values within
a given range, but do not include any values outside that range. More specifically, we are given an array of integers, 
a range represented by a minimum value (minK) and a maximum value (maxK), and we want to find the number of subarrays 
in which the maximum and minimum values are both present within the range, and no other values outside the range are
present.

To solve this problem, we iterate through the array from left to right, keeping track of the indices of the maximum
and minimum values within the range, as well as the index of the first value outside the range (if any). For each
index i, we compute the number of subarrays ending at i that meet the requirements by taking the minimum of the
indices of the maximum and minimum values within the range, and subtracting the index of the first value outside 
the range (if any).

The implementation of this algorithm is straightforward. We initialize variables to keep track of the indices
of the maximum and minimum values within the range, as well as the index of the first value outside the range. 
We then iterate through the array, updating these variables as necessary, and computing the number of subarrays 
ending at the current index that meet the requirements. We add this value to a running total, which we return at
the end.

The time complexity of this algorithm is O(n), where n is the length of the input array, since we iterate 
through the array only once. The space complexity is O(1), since we only need to store a constant number 
of variables to keep track of the relevant indices.

Code
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0, badi = -1, mini = -1, maxi = -1, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) badi = i;
            if (nums[i] == minK) mini = i;
            if (nums[i] == maxK) maxi = i;
            ans += Math.max(0L, Math.min(maxi, mini) - badi);
        }
        return ans;
    }
}
