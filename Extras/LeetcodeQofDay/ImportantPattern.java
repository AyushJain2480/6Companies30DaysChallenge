// Allocation of min no. of pages (gfg Hard)
// Split Array Largest sum (leetcode hard)
// Capacity ship packages within D days (leetcode medium)


class Solution {
    public int shipWithinDays(int[] A, int M) {
       int max = 0;
       int Sum = 0;
       
       if(M > A.length) return -1;
       
       for(int num : A){
           max = Math.max(num,max);
           Sum += num;
       }
       int lo = max;
       int hi = Sum;
       int ans = 0;
       
       while(lo <= hi){
           int sum = 0;
           int st = 1;
           int mid = lo + (hi - lo)/2;
           
           for(int i = 0; i < A.length; i++){
               sum += A[i];
               if(sum > mid){
                  sum = A[i];
                  st++;
               }
           }
           if(st <= M){
               ans = mid;
               hi = mid - 1;
           }else{
               lo = mid + 1;
           }
       }
      return ans;
    }
}
