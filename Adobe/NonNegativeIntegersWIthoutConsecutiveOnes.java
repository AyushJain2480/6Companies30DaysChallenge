 // Brute Force generating all the binary numbers and traversing all the binary numbers to check consecutive ones
class Solution {
    public int findIntegers(int n) {
        int count = 0; 
        for(int i = 0; i <= n; i++){
           boolean flag = true; 
           String bin =  binary(i);
           if(bin.equals('1') || bin.equals('0')) {
             count++;
             continue;
           }
           for(int j = 0; j < bin.length() - 1; j++){
              if(bin.charAt(j) == '1' && bin.charAt(j + 1) == '1'){
                  flag = false;
                  break;
              }
           }
           if(flag == true){
               count++;
           }
        }
        return count;
    }

// converting Integer decimal to binary and representing it in a string 
    public String binary(int dec){
    String bin = Integer.toBinaryString(dec);
    return bin;
    }
}
