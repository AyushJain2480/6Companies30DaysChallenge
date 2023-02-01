class Solution {
   
   int max = 0;
   
   public int maxUniqueSplit(String s) {
       backtracking(s, 0, new HashSet<>());
       return max;
   }
   
   private void backtracking(String s, int i, Set<String> set) {
       if (i == s.length()) {
           max = Math.max(max, set.size());
       } 
       else{
           for (int j = i; j < s.length(); j++) {
               if (!set.contains(s.substring(i , j + 1)))
               {
                   set.add(s.substring(i , j + 1));
                   backtracking(s, j + 1, set);
                   set.remove(s.substring(i , j + 1));
               }
           }
      }
   }
}
