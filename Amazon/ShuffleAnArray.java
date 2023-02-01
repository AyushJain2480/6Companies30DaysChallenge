class Solution {
    
    int[] nums;
    Random r;
    int n;
    public Solution(int[] nums) {
        this.nums = nums;
        this.r = new Random();
        this.n = nums.length;
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        
        int[] a = nums.clone();
        // start from the last element and swap one by one.
        // We don't need to run for the first element (i > 0)
        for(int i = n - 1; i > 0; i--){
            
            // pick a random number from 0 to i
            int j = r.nextInt(i + 1); 
            
            // swap nums[i] with the element at random index
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        return a;
    }
    
    // psvm(){
    //     Solution sol = new Solution(nums);
    //     sol.shuffle();
    //     sol.reset();
    // }
}

