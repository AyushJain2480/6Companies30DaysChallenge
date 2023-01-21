class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
      if(start.equals(end)) return 0;  
        
      HashSet<String> seen = new HashSet<>();
      HashSet<String> bankSet = new HashSet<>();
      for(String b : bank) bankSet.add(b);
      Queue<String> queue = new LinkedList<>();
      int numOfMutation =  0;
      char[] choices = {'A' , 'C' , 'G' , 'T'};  
        
      // initially insert start into the queue and mark it as visited 
      queue.offer(start);
      seen.add(start);
        
      while(!queue.isEmpty()){
      int n = queue.size();
      for(int j = 0; j < n; j++){ 
      // first take out the start element from the queue
      // find all valid mutations from 32 permutations 
      // Enqueue it into the queue
      char[] curr = queue.poll().toCharArray();

      if(String.valueOf(curr).equals(end)) return numOfMutation;
        
      for(int i = 0; i < 8; i++){
          char org_ch = curr[i]; // storing it so that we can again come back 
          for(char choice : choices){
              curr[i] = choice;
              String str = String.valueOf(curr);
              if(!seen.contains(str) && bankSet.contains(str)){ 
                  queue.offer(str); // enqueue
                  seen.add(str); // mark visited
              }
          }
          // after changing ith position with 4 different choices change it back 
          // so that we can find more mutations for next i's
          curr[i] = org_ch;
      }
      }
       numOfMutation++;       
      }   
        return -1;
    }
}
