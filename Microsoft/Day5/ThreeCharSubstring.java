class Solution {
    public int numberOfSubstrings(String s) {
       // Find first the minimum substring by setting 
       // l1 --> a , l2 --> b and l3 --> c 
       // find min of l1 ,l2 and l3
       // if substring from min to current is valid than 
       // 0 1 2....min... curr is also valid 
       // so count = count + min + 1;
       // move i and repeat this process find minm substring again 
       // by setting l1 l2 l3 again and again find min and so on 
       // at last return count
       int n = s.length();
       int count = 0;
       int l1 = -1;
       int l2 = -1;
       int l3 = -1;
       for(int i = 0; i < n; i++){
           if(s.charAt(i) == 'a') l1 = i;
           else if(s.charAt(i) == 'b') l2 = i;
           else l3 = i;
           if(l1 == -1 || l2 == -1 || l3 == -1) continue; // if any condition is true means a min substring is not found yet 
           int min = Math.min(l1,Math.min(l2,l3));
           count = count + min + 1;
       }
       return count;
    }
}
