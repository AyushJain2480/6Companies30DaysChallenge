class Solution {
// From the last to start , the leftmost position that can reach the current position

    public int jump(int[] nums) {
        int pos = nums.length - 1;
        int jumps = 0;
        while(pos != 0){
            for(int i = 0; i < pos; i++){
                if(i + nums[i] >= pos){
                    pos = i;
                    jumps++;
                    break;
                }
            }
        }
        return jumps;
    }
}
