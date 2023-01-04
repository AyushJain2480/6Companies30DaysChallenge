//  what is max till 9 --> 10
//  -----------------> 
//  [2,6,4,8,10,9,15]
//              ^
//              i
//  so we know here that a 10(max) is present in the left side
//  and now if the element at i is less than that max than we know that its a violation


//  what is min till 6 --> 2 
//  <---------------
//  [2,6,4,8,10,9,15]
//     ^
//     i
//  so we know here that a 4(min) is present somewhere on the right side
//  and now if the element at i is more than that min than we know that its a violation


class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int end = -2 , max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            max = Math.max(max,nums[i]);
            if(nums[i] < max){
                end = i;
            }
        }

        int begin = -1 , min = Integer.MAX_VALUE;

        for(int i = nums.length - 1; i >= 0; i--){
            min = Math.min(min,nums[i]);
            if(nums[i] > min){
                begin = i;
            }
        }
        return end - begin + 1;
    }
}
