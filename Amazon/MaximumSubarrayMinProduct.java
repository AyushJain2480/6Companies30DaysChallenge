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
