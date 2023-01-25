/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr)    {
        int n = mountainArr.length();
        int peak = findPeak(mountainArr, 0 , n - 1);
        int increaseMountain =  BS(target, mountainArr , 0 , peak);
        if(increaseMountain == -1){
           return RBS(target, mountainArr , peak , n - 1); 
        }  
        return increaseMountain; 
    }
    
    private int findPeak(MountainArray mountainArr, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            int midPlusOneVal = mountainArr.get(mid + 1);
            if (midVal < midPlusOneVal) {
                // you are in the increasing part of the array
                start = mid + 1;
            } else {
                // you are in the decreasing part of the array
                end = mid;
            }
        }
        return start;
        // IN the end start == end and pointing to the largest number because of the 2 checks above 
        // start and end are always trying to find max element in the above two checks 
        // hence when they are pointing to just one element that is the maximum one because that is what the check says
    }
        
    public int BS(int target, MountainArray mountainArr, int start , int end){
        if(end >= start){
            int mid = (start + end) / 2;
            if(mountainArr.get(mid) == target)
                return mid;
            if(mountainArr.get(mid) < target)
                return BS(target, mountainArr, mid + 1, end);
            else
                return BS(target, mountainArr, start , mid - 1);
        }
        return -1;
    }
    
    public int RBS(int target, MountainArray mountainArr, int start , int end){
        if(end >= start){
            int mid = (start + end) / 2;
            if(mountainArr.get(mid) == target)
                return mid;
            if(mountainArr.get(mid) > target)
                return RBS(target, mountainArr, mid + 1, end);
            else
                return RBS(target, mountainArr, start , mid - 1);
        }
        return -1;
    }
}
