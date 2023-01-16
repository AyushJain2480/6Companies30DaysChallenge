class Solution {
    // num[i] - rev(num[i]) == num[j] - rev[num[j]]
    // How many pairs in B satisfy below condition 
    // B[i] == B[j]
    
   
    public int countNicePairs(int[] nums) {
       int finalCount = 0;
       int mod = (int)Math.pow(10,9) + 7;
       Map<Integer,Integer> map = new HashMap<>();
       for(int i = 0; i < nums.length; i++){
           int element = nums[i] - rev(nums[i]);
           if(!map.containsKey(element)){
               map.put(element,1);
           }else{
               int repeatCount = map.get(element);
               map.put(element , repeatCount + 1);
               finalCount = (finalCount + repeatCount) % mod;
           }
       }
        return finalCount ;
    }

    private int rev(int i) {
    int res = 0;
    while (i > 0) {
    res = res * 10 + i % 10;
    i /= 10;
    }
    return res;
    }
}
