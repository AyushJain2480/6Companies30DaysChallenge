class Solution {
    // Last significant bit of even num is  0 and of odd is 1

    // public int countOdds(int low, int high) {
    //     int count = 0;
    //     for(int i = low; i <= high; i++){
    //         int val = i & 1;
    //         if(val == 1){
    //             count++;
    //         }
    //     }
    //     return count;
    // }
    
    public int countOdds(int low , int high){
      int length = high - low + 1;
      if((length & 1) != 1) return length/2;
      
      if((low & 1) == 1) return (length/2) + 1;
      else return length/2;
    }
}
