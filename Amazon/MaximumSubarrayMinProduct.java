//for this problem, we can quickly know the sum of an subarray with prefix sum array
//so the difficult point is how to get the min value for each array very quickly
//we can use segment tree
//but this still O(N^2), since you will find for each pair of [i, j]
//we can focus on each number in nums, let it be the min and we expand from this number to right and to left
//we want to ask what is the first number on the right that is smaller than this number
//and what is the first number on the left that is smaller than this number
class Solution {
    public int maxSumMinProduct(int[] nums) {
        int N = nums.length;
        int[] l = new int[N], r = new int[N];
        long[] s = new long[N + 1];
        long ans = 0;

        // Closest smaller values on left and right
        for (int i = 0; i < N; i++) {
            int prev = i - 1;
            while (prev >= 0 && nums[prev] >= nums[i]) {
                 prev = l[prev];
            } 
            l[i] = prev;
        }
        
        for (int i = N - 1; i >= 0; i--) {
            int next = i + 1;
            while (next < N && nums[next] >= nums[i]){
                next = r[next];
            }   
            r[i] = next;
        }

        // Pre-sum
        for (int i = 0; i < N; i++) 
            s[i + 1] = s[i] + nums[i];

        // Find max sum
        for (int i = 0; i < N; i++)
          ans = Math.max(ans, (s[r[i]] - s[l[i] + 1]) * nums[i]);

        return (int)(ans % 1_000_000_007);
    }
}

// Bonus Question- The above problem is similar to largest rectangle in histogram but its difficult to find that we can solve it using stack also 
// but its little difficult 
// Let me explain this idea in the most intuitive way: intuitively, suppose that the current position is i, find a height smaller
// than height[i] before i (nearest to i), and then find a height smaller than height[i] (nearest to i) after i, so that all heights 
// sandwiched in the middle (excluding both ends) are higher than height [i], so you can use height [i] * interval length (excluding both ends)
// to calculate the maximum rectangular area.Then the algorithm is easy to understand.


class Solution {
    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        int[] l = new int[N], r = new int[N];

        // Closest smaller values on left and right
        for (int i = 0; i < N; i++) {
            int prev = i - 1;
            while (prev >= 0 && heights[prev] >= heights[i]) {
                 prev = l[prev];
            } 
            l[i] = prev;
        }
        
        for (int i = N - 1; i >= 0; i--) {
            int next = i + 1;
            while (next < N && heights[next] >= heights[i]){
                next = r[next];
            }   
            r[i] = next;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (r[i] - l[i] - 1));
        }
        return maxArea;
    }
}



