// worst case is O(n/2) i.e O(n) when the single element is present at the end.
class Solution {
    public int singleNonDuplicate(int[] nums) {
        for(int i = 0; i < nums.length - 1; i+=2){
            if(nums[i] == nums[i + 1]) continue;
            return nums[i];
        }
        return nums[nums.length - 1];
    }
}

// log(N)
// agar mid odd he or left wale se match hora he to right me hoga single ele
// agar mid eve he or right wale se match hora he to right me hoga single ele
class Solution{
    public int singleNonDuplicate(int[] nums){
         int left = 0;
         int right = nums.length - 1;
         while(left < right){
             int mid = left + (right - left)/2;
             if((mid % 2 == 0) && nums[mid] == nums[mid + 1]  ||  (mid % 2 != 0) && nums[mid] == nums[mid - 1]){
                 left = mid + 1;
             }else{
                 right = mid;
             }
         }
        return nums[left];
    }
}


class Solution{
    public int singleNonDuplicate(int[] nums){
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == nums[mid + 1]) mid = mid - 1; // pairs must be on same side for accurate calculation 
            if((mid - lo + 1) % 2 != 0){ // if left side array is odd than single ele will be present in the left side.
                hi = mid;
            }else{
                lo = mid + 1; // if right side array is oddd than single ele will be present in the right side.
            }
        }
        return nums[lo];
    }
}
